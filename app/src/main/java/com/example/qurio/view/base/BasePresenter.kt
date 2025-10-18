package com.example.qurio.view.base

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class BasePresenter<V : BaseView>() : Presenter<V> {

    private val job = SupervisorJob()
    val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    protected var view: V? = null
        private set

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        coroutineScope.coroutineContext.cancelChildren()
        view = null
    }

    override fun onDestroy() {
        job.cancel()
    }

    protected fun <T> tryToExecute(
        function: suspend () -> T,
        onSuccess: ((T) -> Unit)? = null,
        onError: (Throwable) -> Unit,
        scope: CoroutineScope = CoroutineScope(Dispatchers.Main),
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ): Job = runWithErrorHandling(onError, scope, dispatcher) {
        val result = function()
        withContext(Dispatchers.Main) {
            onSuccess?.invoke(result)
        }
    }

    private fun runWithErrorHandling(
        onError: (Throwable) -> Unit,
        scope: CoroutineScope,
        dispatcher: CoroutineDispatcher,
        function: suspend () -> Unit,
    ): Job {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            scope.launch {
                Log.d(
                    "BasePresenter",
                    "Exception caught: ${throwable::class.simpleName}",
                    throwable
                )
                onError(throwable)
            }
        }
        return scope.launch(dispatcher + coroutineExceptionHandler) {
            function()
        }
    }
}
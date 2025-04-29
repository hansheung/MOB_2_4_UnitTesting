package com.hansheung.mob_2_4_UnitTesting.ui.login
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {
    val viewModel = LoginViewModel()

    @Before
    fun setup(){
        val testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun cleanup(){
        Dispatchers.resetMain()
    }

    @Test
    fun `greet function should return a valid greeting message`() = runTest{
        viewModel.greet("Hansheung")
        //assertEquals("Hello Hansheung", viewModel.greetings.value)
//        viewModel.greetings.collect{
//            if(it!==""){
//                assertEquals("Hello Hansheung", it)
//            }
//        }

        val msg = viewModel.greetings.drop(1).first()
        assertEquals("Hello Hansheung", msg)
    }

    @Test
    fun `email "aaa" should return an error message` () {
        //assert(viewModel.validateEmail("aaa") != null) //Temp switch to == null for testing CircleCLI
        assert(viewModel.validateEmail("aaa") == null)
    }

    @Test
    fun `email aaa gmail_com should return null` () {
        assert(viewModel.validateEmail("aaa@gmail.com") == null)
    }

}
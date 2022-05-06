package org.dev.diceroller

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import org.dev.diceroller.models.DiceResult

class DiceViewModel(private val repository: DiceRepository) : ViewModel() {

    val allResults: LiveData<List<DiceResult>> = repository.result.asLiveData()

    fun insert(diceResult: DiceResult) = viewModelScope.launch {
        repository.insert(diceResult)
    }

    fun search(face: String) : LiveData<List<DiceResult>> {
        return repository.search(face)
    }
}

class DiceViewModelFactory(private val repository: DiceRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiceViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DiceViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class ${modelClass.name}")
    }
}

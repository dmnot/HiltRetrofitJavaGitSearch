package com.example.hiltretrofitjavagitsearch.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hiltretrofitjavagitsearch.model.RecyclerData;
import com.example.hiltretrofitjavagitsearch.network.RetroRepository;
import com.example.hiltretrofitjavagitsearch.network.RetroServiceInterface;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainActivityViewModel extends ViewModel {
    MutableLiveData<List<RecyclerData>> liveData;
    @Inject
    RetroServiceInterface retroServiceInterface;

    @Inject
    public MainActivityViewModel() {
        this.liveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<RecyclerData>> getLiveData() {
        return liveData;
    }
    //-----------------------------------------------------------------------------
    public void makeAPICall() {
        RetroRepository retroRepository = new RetroRepository(retroServiceInterface);
        retroRepository.makeAPICall("hilt",liveData);
    }
    //-----------------------------------------------------------------------------
}

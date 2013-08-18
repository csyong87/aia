package com.techmahindra.aia.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.techmahindra.aia.web.datastore.DataStore;

/**
 * A base class of aia web controllers
 * <p/>
 * 
 * @author Christian
 * 
 */
@Controller
public class ControllerBase {

    @Autowired
    private DataStore dataStore;

    /**
     * @return the dataStore
     */
    public DataStore getDataStore() {
        return dataStore;
    }

}

package com.example.proyectoevade;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences pref; //Almacenamiento de preferencias
    SharedPreferences.Editor editor; //Aquí se crea el editor para cambios
    Context _context;

    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "Evade"; //Nombre del archivo
    private static final String IS_LOGGED = "Identificado"; // Contraseñas
    public static final String KEY_EMAIL = "Email";
    public static final String KEY_PASSWORD = "Clave";

    //Constructor
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String email, String password) {
        editor.putBoolean(IS_LOGGED, true);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);
        editor.commit();
    }

    public HashMap<String, String> getUserPref() {
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));
        return user;
    }

    public void loginStatus() {
        if (!this.isLogged()) {
            Intent intent = new Intent(_context, Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(intent);

        }
    }

    boolean isLogged() {return pref.getBoolean(IS_LOGGED , false); }


    public void logOut(){
        editor.clear();
        editor.commit();
        Intent intent = new Intent(_context, Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(intent);
    }
}
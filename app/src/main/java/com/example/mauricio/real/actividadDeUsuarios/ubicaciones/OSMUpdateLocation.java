package com.example.mauricio.real.actividadDeUsuarios.ubicaciones;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.example.mauricio.real.actividadDeUsuarios.Activity_principal;

/**
 * Created by equipo on 07/08/2017.
 */

public class OSMUpdateLocation implements LocationListener {
    private Fragment_mapa actividad;

    public OSMUpdateLocation(Fragment_mapa actividad) {
        this.actividad = actividad;
    }

    @Override
    public void onLocationChanged(Location location) {
        actividad.actualizaPosicionActual(location);
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
}

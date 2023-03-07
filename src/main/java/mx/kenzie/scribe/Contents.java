package mx.kenzie.scribe;

import mx.kenzie.argo.Json;

import java.util.Map;

interface Contents {
    default Map<String, Object> toMap() {
        return Json.toMap(this);
    }
}

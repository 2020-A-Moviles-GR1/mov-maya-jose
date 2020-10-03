package com.example.myapplication

class Pan(val cantidad: String?, val name: String?, val precio: String?) {

    override fun toString(): String {
        return cantidad +"-"+ name +"-"+ precio
    }
}
package com.example.deber

import android.os.Parcel
import android.os.Parcelable

class Cliente(var id:Int?,
              var numeroTelefonoCliente:Int,
              var nombreCliente:String,
              var nombreCompletoCliente:String,
              var direccionCliente:String,
              var fechaNacimientoCliente:String,
              var edad:Int,
              var equipoFutbolId:Int): Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun toString(): String {
        return "Número Telefono Cliente: ${numeroTelefonoCliente} Nombre Completo Cliente: ${nombreCompletoCliente} Direccion Cliente: ${direccionCliente} Fecha Nacimiento:${fechaNacimientoCliente} Edad:${edad}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeInt(numeroTelefonoCliente)
        parcel.writeString(nombreCliente)
        parcel.writeString(nombreCompletoCliente)
        parcel.writeString(direccionCliente)
        parcel.writeString(fechaNacimientoCliente)
        parcel.writeInt(edad)
        parcel.writeInt(equipoFutbolId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cliente> {
        override fun createFromParcel(parcel: Parcel): Cliente {
            return Cliente(parcel)
        }

        override fun newArray(size: Int): Array<Cliente?> {
            return arrayOfNulls(size)
        }
    }


}

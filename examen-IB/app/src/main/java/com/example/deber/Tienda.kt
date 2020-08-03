package com.example.deber

import android.os.Parcel
import android.os.Parcelable


class Tienda(var id:Int?,
             var nombreTienda:String,
             var direccionTienda:String,
             var fechaCreacionTienda:String,
             var valorTienda:Double,
             var familiar:String) :Parcelable{


    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readString().toString()
    ) {
    }

    override fun toString(): String {
        return "NOMBRE TIENDA: ${nombreTienda} DIRECION TIENDA: ${direccionTienda} FECHA CREACION: ${fechaCreacionTienda} VALOR TIENDA:${valorTienda} FAMILIAR:${familiar}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(nombreTienda)
        parcel.writeString(direccionTienda)
        parcel.writeString(fechaCreacionTienda)
        parcel.writeDouble(valorTienda)
        parcel.writeString(familiar)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tienda> {
        override fun createFromParcel(parcel: Parcel): Tienda {
            return Tienda(parcel)
        }

        override fun newArray(size: Int): Array<Tienda?> {
            return arrayOfNulls(size)
        }
    }


}
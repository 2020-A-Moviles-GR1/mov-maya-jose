package com.example.deber

class BDJugador {
    companion object {
        val LST_CLIENTE:ArrayList<Cliente> = ArrayList();
        var serial:Int= 1;

        fun agregarJugador(cliente: Cliente):ArrayList<Cliente>{
            cliente.id = serial
            serial++
            LST_CLIENTE.add(cliente)
            return LST_CLIENTE
        }

        fun mostrarJugador(padreId:Int): List<Cliente> {
            val lstFiltradaJugador = this.LST_CLIENTE.filter { it.equipoFutbolId ==  padreId}
            return lstFiltradaJugador
        }

        fun eliminarJugador(id:Int){
            this.LST_CLIENTE.removeAll{ it.id == id }
        }

        fun actualizarJugador(cliente: Cliente){
            val indice = this.LST_CLIENTE.indexOfFirst { it.id == cliente.id }
            this.LST_CLIENTE[indice] = cliente
        }

    }

}
package com.example.proyecto_dsm_g7.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto_dsm_g7.data.dao.casaCanceladoDAO
import com.example.proyecto_dsm_g7.data.dao.casaFiltroDAO
import com.example.proyecto_dsm_g7.data.dao.casaPorPagarDAO
import com.example.proyecto_dsm_g7.data.dao.condominioDAO
import com.example.proyecto_dsm_g7.data.dao.detalleDAO
import com.example.proyecto_dsm_g7.data.dao.reciboDAO
import com.example.proyecto_dsm_g7.data.model.CasaCancelado
import com.example.proyecto_dsm_g7.data.model.CasaFiltro
import com.example.proyecto_dsm_g7.data.model.CasaPorpagar
import com.example.proyecto_dsm_g7.data.model.condominio
import com.example.proyecto_dsm_g7.data.model.detalle
import com.example.proyecto_dsm_g7.data.model.recibo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
class ScreenViewModel(key : Int, fechaI: String, fechaF: String, estado: Int) : ViewModel() {
    //CONDOMINIO
    private val condominiodao = condominioDAO()
    private val _listaCondominio = MutableLiveData<List<condominio>>()
    val listaCondominio : LiveData<List<condominio>> = _listaCondominio

    //CASA CANCELADO
    private  val casacanceladodao = casaCanceladoDAO()
    private val _listaCasaCancelado = MutableLiveData<List<CasaCancelado>>()
    val listaCasaCancelado : LiveData<List<CasaCancelado>> = _listaCasaCancelado

    //CASA POR PAGAR
    private  val casaporpagardao = casaPorPagarDAO()
    private val _listaCasaPorPagar = MutableLiveData<List<CasaPorpagar>>()
    val listaCasaPorPagar : LiveData<List<CasaPorpagar>> = _listaCasaPorPagar

    //CASA FILTROS
    private  val casaFiltroDAO = casaFiltroDAO()
    private  val _listaCasaFiltro = MutableLiveData<List<CasaFiltro>>()
    val listaCasaFiltro : LiveData<List<CasaFiltro>> = _listaCasaFiltro

    //RECIBO
    private  val recibodao = reciboDAO()
    private  val _listaRecibo = MutableLiveData<List<recibo>>()
    val listaRecibo : LiveData<List<recibo>> = _listaRecibo

    //DETALLE RECIBO
    private val detalleDAO = detalleDAO()
    private val _listaDetalle = MutableLiveData<List<detalle>>()
    val listadetalle : LiveData<List<detalle>> = _listaDetalle

    init {

        //INICIALIZAR LISTA CONDOMINIO
        viewModelScope.launch(Dispatchers.IO) {

            val result = condominiodao.getCondominio()

            withContext(Dispatchers.Main) {
                _listaCondominio.value = result
            }
        }

        //INICIALIZAR LISTA CASA CANCELADO
        viewModelScope.launch(Dispatchers.IO) {
            val result = casacanceladodao.getCasaCancelado(key)

            withContext(Dispatchers.Main) {
                _listaCasaCancelado.value = result
            }
        }

        //INICIALIZAR LISTA CASA POR PAGAR
        viewModelScope.launch(Dispatchers.IO) {
            val result = casaporpagardao.getCasaPorPagar(key)

            withContext(Dispatchers.Main) {
                _listaCasaPorPagar.value = result
            }
        }

        //INICIALIZAR LISTA Recibo
        viewModelScope.launch(Dispatchers.IO) {
            //var estado = 1
            val result = recibodao.getRecibo(key, fechaI, fechaF, estado)

            withContext(Dispatchers.Main) {
                _listaRecibo.value = result
            }
        }
        //INICIALIZAR LISTA Detalle
        viewModelScope.launch(Dispatchers.IO) {
            val result = detalleDAO.getDetalle(key)

            withContext(Dispatchers.Main) {
                _listaDetalle.value = result
            }
        }

        //INICIALIZAR LISTA CASA FIlTRO
        viewModelScope.launch(Dispatchers.IO) {
            val fechaInicio = LocalDate.of(2023, 8, 1)
            val fechaFin = LocalDate.of(2023, 8, 1)
            val result = casaFiltroDAO.getCasaFiltro(1, fechaInicio, fechaFin)

            withContext(Dispatchers.Main) {
                _listaCasaFiltro.value = result
            }
        }
    }
}
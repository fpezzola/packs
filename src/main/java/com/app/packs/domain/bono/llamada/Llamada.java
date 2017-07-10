package com.app.packs.domain.bono.llamada;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.app.packs.domain.bono.Bono;
import com.app.packs.enums.ETipoTrafico;

@Entity
@DiscriminatorValue(value=ETipoTrafico.Values.LLAMADA)
public class Llamada extends Bono{

}

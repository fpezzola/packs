package com.app.packs.domain.bono.sms;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.app.packs.domain.bono.Bono;
import com.app.packs.enums.ETipoTrafico;

@Entity
@DiscriminatorValue(value=ETipoTrafico.Values.SMS)
public class Sms extends Bono{

}

package com.nea.sm.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "grup")
@Data
public class Grup {

	@Id
	@SequenceGenerator(name = "seq_grup", allocationSize = 1, sequenceName = "seq_grup")
    @GeneratedValue(generator = "seq_grup", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "ad")
    private String ad;
	
	@ManyToOne
    @JoinColumn(name = "kurs_id")
    private Kurs kurs;
	
	@ManyToOne
    @JoinColumn(name = "ogretmen_id")
    private Ogretmen ogretmen;

	@Column(name = "ogrenci_sayisi")
	private int ogrenciSayisi;

	@ManyToOne
    @JoinColumn(name = "salon_id")
	private Salon salon;
    
    @Column(name = "baslama_tarihi")
    @Temporal(TemporalType.DATE)
    private Date baslamaTarihi;
    
    @Column(name = "bitis_tarihi")
    @Temporal(TemporalType.DATE)
    private Date bitisTarihi;
    
    
    @Override
    public boolean equals(Object obj) {
    	if(obj instanceof Grup){
    		if(((Grup)obj).getId().equals(this.id)){
    			return true;
    		}
    	}
    	return false;
    }
}

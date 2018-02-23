package com.nea.sm.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.nea.sm.web.entity.Grup;
import com.nea.sm.web.repository.GrupRespository;

@Controller("grupConverter")
@Scope(value="request")
public class GrupConverter implements Converter {

	@Autowired
	private GrupRespository grupRespository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0 && !value.equals("null")) {
			try {
				Grup grup = grupRespository.findOne(new Long(value));
				return grup;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("null") && value instanceof Grup ) {
			return String.valueOf(((Grup)value).getId());
		} else {
			return null;
		}
	}
}

package de.larskiesow.andca.Controller;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.ValidationException;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.parameter.Value;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.UidGenerator;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;

import de.larskiesow.andca.AndCAApplication;
import de.larskiesow.andca.matterhorn.GetIcal;

/**
 * Created by cgreweling on 10.02.14.
 */


public class IcalList {



    public String getIcalFromMatterhornCore(AndCAApplication app){
        String temp  = new GetIcal().doInBackground(app);
        StringReader sin = new StringReader(temp.toString());

        CalendarBuilder builder = new CalendarBuilder();

/*
        Calendar calendar = null;
        try {
            calendar = builder.build(sin);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserException e) {
            e.printStackTrace();
        }
*/
        String ausgabe = null;
  /*      for (Iterator i = calendar.getComponents().iterator(); i.hasNext();) {
            Component component = (Component) i.next();
            ausgabe+="Component[" + component.getName()+"]" ;
        }
*/
    return ausgabe;
    }
}

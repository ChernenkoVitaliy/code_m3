package com.company.hw.m3_2.task1;

/*Есть список поездов, представленый в виде XML. Вывести на экран информацию о тех поездах,
* которые отправляются с Киева*/

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class MainM2T1 {
    public static void main(String[] args) {
        File file = new File("D:\\my_files\\java\\java pro\\filesForTest\\trains.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TrainsList.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            TrainsList list = (TrainsList) unmarshaller.unmarshal(file);

            for (Train t : list.getTrains()) {
                System.out.println(t);
            }

            System.out.println("\nTrains from Kiev: ");
            for (Train t : list.getTrains()) {
                if (t.getFrom().equals("Kyiv"))
                    System.out.println(t);
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}



/*<?xml version="1.0" encoding="UTF-8"?>

<trains>
	<train id="1">
		<from>Kyiv</from>
		<to>Lviv</to>
		<date>19.12.2019</date>
		<departure>15:55</departure>
	</train>
	<train id="2">
		<from>Kyiv</from>
		<to>Odessa</to>
		<date>30.11.2019</date>
		<departure>00:30</departure>
	</train>
	<train id="3">
		<from>Lviv</from>
		<to>Kyiv</to>
		<date>11.11.2019</date>
		<departure>11:11</departure>
	</train>
	<train id="4">
		<from>Odessa</from>
		<to>Lviv</to>
		<date>30.12.2019</date>
		<departure>14:30</departure>
	</train>
	<train id="5">
		<from>Bucha</from>
		<to>Rabota</to>
		<date>27.11.2019</date>
		<departure>06:54</departure>
	</train>
</trains>*/
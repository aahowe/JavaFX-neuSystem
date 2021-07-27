package System.service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author wanghao
 */
public class BedService {
    public static BedListWrapper loadBed(String path) {
        File file = new File(path);
        try {
            JAXBContext context = JAXBContext
                    .newInstance(BedListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            return (BedListWrapper) um.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveBed(BedListWrapper wrapper,String path) {
        try {
            File file = new File(path);
            JAXBContext context = JAXBContext
                    .newInstance(BedListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(wrapper, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

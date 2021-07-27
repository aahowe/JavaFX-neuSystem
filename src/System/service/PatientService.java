package System.service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author wanghao
 */
public class PatientService {
    public static PaListWrapper loadPa(String path) {
        File file = new File(path);
        try {
            JAXBContext context = JAXBContext
                    .newInstance(PaListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            return (PaListWrapper) um.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void savePa(PaListWrapper wrapper,String path) {
        try {
            File file = new File(path);
            JAXBContext context = JAXBContext
                    .newInstance(PaListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(wrapper, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

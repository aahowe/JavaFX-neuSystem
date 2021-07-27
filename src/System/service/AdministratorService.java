package System.service;

import System.model.Administrator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.Objects;


/**
 * @author wanghao
 */
public class AdministratorService {

    public static AdmListWrapper loadAdm(String path) {
        File file = new File(path);
        try {
            JAXBContext context = JAXBContext
                    .newInstance(AdmListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            return (AdmListWrapper) um.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveAdm(AdmListWrapper wrapper,String path) {
        try {
            File file = new File(path);
            JAXBContext context = JAXBContext
                    .newInstance(AdmListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(wrapper, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Administrator login(String id,String password){
        List<Administrator> list1 = Objects.requireNonNull(loadAdm("src/System/data/administratorlist1.xml")).getAdm();
        List<Administrator> list2 = Objects.requireNonNull(loadAdm("src/System/data/administratorlist2.xml")).getAdm();
        List<Administrator> list3 = Objects.requireNonNull(loadAdm("src/System/data/administratorlist3.xml")).getAdm();
        for (Administrator i:list1){
            if (id.equals(i.getId()) && password.equals(i.getPassword())){
                return i;
            }
        }
        for (Administrator i:list2){
            if (id.equals(i.getId()) && password.equals(i.getPassword())){
                return i;
            }
        }
        for (Administrator i:list3){
            if (id.equals(i.getId()) && password.equals(i.getPassword())){
                return i;
            }
        }
        return null;
    }

}

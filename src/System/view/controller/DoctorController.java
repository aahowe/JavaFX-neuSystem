package System.view.controller;

import System.model.*;
import System.Main;
import System.service.*;
import com.jfoenix.controls.*;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import static System.Main.using;

/**
 * @author wanghao
 */
public class DoctorController implements Initializable {

    @FXML
    private JFXButton analyze;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton edit;

    @FXML
    private JFXComboBox<String> menu;

    @FXML
    private JFXToggleButton name;

    @FXML
    private JFXToggleButton birthday;

    @FXML
    private JFXToggleButton sex;

    @FXML
    private JFXToggleButton phone;

    @FXML
    private JFXToggleButton eperson;

    @FXML
    private JFXToggleButton ephone;

    @FXML
    private JFXTextField searchfield;

    @FXML
    private JFXProgressBar progressbar;

    @FXML
    private TableView<Patient> tableview1;

    @FXML
    private TableView<Bed> tableview2;

    @FXML
    private TableView<Patient> tableview3;

    @FXML
    private TableColumn<Patient, String> namecol;

    @FXML
    private TableColumn<Patient, String> birthcol;

    @FXML
    private TableColumn<Patient, String> sexcol;

    @FXML
    private TableColumn<Patient, String> phonecol;

    @FXML
    private TableColumn<Patient, String> epersoncol;

    @FXML
    private TableColumn<Patient, String> ephonecol;

    @FXML
    private TableColumn<Bed, String> bidcol;

    @FXML
    private TableColumn<Bed, String> blocationcol;

    @FXML
    private TableColumn<Bed, String> bstartcol;

    @FXML
    private TableColumn<Bed, String> bendcol;

    @FXML
    private TableColumn<Bed, String> bnamecol;

    @FXML
    private TableColumn<Bed, String> bsexcol;

    @FXML
    private TableColumn<Bed, String> bagecol;

    @FXML
    private TableColumn<Bed, String> bidcodecol;

    @FXML
    private TableColumn<Bed, String> bstatuscol;

    @FXML
    private TableColumn<?, ?> typecol;

    @FXML
    private TableColumn<?, ?> rlocationcol;

    @FXML
    private TableColumn<?, ?> capacitycol;

    @FXML
    private TableColumn<?, ?> explaincol;

    @FXML
    private TableColumn<?, ?> waitcol;

    @FXML
    private TableView<Analysis> tableview4;

    @FXML
    private TableColumn<Analysis, String> anamecol;

    @FXML
    private TableColumn<Analysis, String> asexcol;

    @FXML
    private TableColumn<Analysis, String> atnamecol;

    @FXML
    private TableColumn<Analysis, String> attypecol;

    @FXML
    private TableColumn<Analysis, String> atimecol;

    @FXML
    private TableColumn<Analysis, String> apnamecol;

    @FXML
    private TableColumn<Analysis, String> alevelcol;

    @FXML
    private TableView<Template> ttableview;

    @FXML
    private TableColumn<Template, String> tidcol;

    @FXML
    private TableColumn<Template, String> tnamecol;

    @FXML
    private TableColumn<Template, String> ttypecol;

    @FXML
    private TableColumn<Template, JFXCheckBox> qcbcol;

    @FXML
    private TableView<Question> qtableview;

    @FXML
    private JFXButton tadd;

    @FXML
    private JFXButton tedit;

    @FXML
    private JFXButton tdelete;

    @FXML
    private JFXButton tdetails;

    @FXML
    private JFXTextField tsearch;

    @FXML
    private TableColumn<Question, String> qidcol;

    @FXML
    private TableColumn<Question, String> qtextcol;

    @FXML
    private TableColumn<Question, String> qtypecol;

    @FXML
    private JFXTextField qsearch;

    @FXML
    private JFXButton qadd;

    @FXML
    private JFXButton qedit;

    @FXML
    private JFXButton qdelete;

    @FXML
    private Label timeInfoLabel;

    @FXML
    private JFXTextField zname;

    @FXML
    private JFXTextField zpassword;

    @FXML
    private JFXTextField zspcialty;

    @FXML
    private JFXTextField zphone;

    @FXML
    private JFXDatePicker zbirthday;

    @FXML
    private Label usingtext;


    private ObservableList<Patient> paData = FXCollections.observableArrayList();
    private ObservableList<Bed> bedData = FXCollections.observableArrayList();
    private ObservableList<Question> qData = FXCollections.observableArrayList();
    private ObservableList<Template> tData = FXCollections.observableArrayList();
    private ObservableList<Analysis> aData = FXCollections.observableArrayList();
    FilteredList<Question> filterq = new FilteredList<>(qData);
    private int choice = 1;
    private Stage dialogStage;

    @FXML
    void add(ActionEvent event) throws IOException {
        switch (choice) {
            default:
                break;
            case 1:
                Patient patient = new Patient();
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("../fxml/PatientAE.fxml"));
                AnchorPane page1 = loader1.load();
                Stage dialogStage1 = new Stage();
                dialogStage1.setTitle("增加或删除成员");
                dialogStage1.initModality(Modality.WINDOW_MODAL);
                dialogStage1.initOwner(Main.primaryStage);
                Scene scene1 = new Scene(page1);
                dialogStage1.setScene(scene1);
                PatientAEController controller1 = loader1.getController();
                controller1.setDialogStage(dialogStage1);
                controller1.add(patient);
                dialogStage1.showAndWait();
                //保存
                if (controller1.isOk()) {
                    paData.add(patient);
                    save(choice);
                }
                break;
            case 2:
                Bed bed = new Bed();
                // Load the fxml file and create a new stage for the popup dialog.
                FXMLLoader loader2 = new FXMLLoader();
                loader2.setLocation(getClass().getResource("../fxml/BedAE.fxml"));
                AnchorPane page2 = loader2.load();

                // Create the dialog Stage.
                Stage dialogStage2 = new Stage();
                dialogStage2.setTitle("增加或删除床位");
                dialogStage2.initModality(Modality.WINDOW_MODAL);
                dialogStage2.initOwner(Main.primaryStage);
                Scene scene2 = new Scene(page2);
                dialogStage2.setScene(scene2);
                BedAEController controller2 = loader2.getController();
                controller2.setDialogStage(dialogStage2);
                controller2.add(bed);
                dialogStage2.showAndWait();
                //保存
                if (controller2.isOk()) {
                    bedData.add(bed);
                    save(choice);
                }
                break;
            case 3:

                break;
        }

    }

    @FXML
    void delete(ActionEvent event) {
        switch (choice) {
            default:
                break;
            case 1:
                int selectedIndex1 = tableview1.getSelectionModel().getSelectedIndex();
                if (selectedIndex1 >= 0) {
                    BedListWrapper wrapper = BedService.loadBed("src/System/data/bedlist.xml");
                    assert wrapper != null;
                    for (Bed i : wrapper.getBed()) {
                        if (i.getPatient().getIdcode().equals(tableview1.getSelectionModel().getSelectedItem().getIdcode())) {
                            wrapper.getBed().remove(i);
                            break;
                        }
                    }
                    tableview1.getItems().remove(selectedIndex1);
                    BedService.saveBed(wrapper, "src/System/data/bedlist.xml");
                    save(choice);
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.primaryStage);
                    alert.setTitle("错误");
                    alert.setHeaderText("未选择对象！");
                    alert.setContentText("请选择要删除的对象！");
                    alert.showAndWait();
                }
                break;
            case 2:
                int selectedIndex2 = tableview2.getSelectionModel().getSelectedIndex();
                if (selectedIndex2 >= 0) {
                    tableview2.getItems().remove(selectedIndex2);
                    save(choice);
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.primaryStage);
                    alert.setTitle("错误");
                    alert.setHeaderText("未选择对象！");
                    alert.setContentText("请选择要删除的对象！");
                    alert.showAndWait();
                }
                break;
            case 3:

                break;
            case 4:
                int selectedIndex4 = tableview4.getSelectionModel().getSelectedIndex();
                if (selectedIndex4 >= 0) {
                    tableview4.getItems().remove(selectedIndex4);
                    save(choice);
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.primaryStage);
                    alert.setTitle("错误");
                    alert.setHeaderText("未选择对象！");
                    alert.setContentText("请选择要删除的对象！");
                    alert.showAndWait();
                }
                break;

        }
    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        switch (choice) {
            default:
                break;
            case 1:
                Patient patient = tableview1.getSelectionModel().getSelectedItem();
                if (patient != null) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("../fxml/PatientAE.fxml"));
                    AnchorPane page = loader.load();

                    // Create the dialog Stage.
                    Stage dialogStage = new Stage();
                    dialogStage.setTitle("增加或删除成员");
                    dialogStage.initModality(Modality.WINDOW_MODAL);
                    dialogStage.initOwner(Main.primaryStage);
                    Scene scene = new Scene(page);
                    dialogStage.setScene(scene);

                    // Set the person into the controller.
                    PatientAEController controller = loader.getController();
                    controller.setDialogStage(dialogStage);
                    controller.edit(patient);
                    // Show the dialog and wait until the user closes it
                    dialogStage.showAndWait();
                    //保存
                    if (controller.isOk()) {
                        BedListWrapper wrapper = BedService.loadBed("src/System/data/bedlist.xml");
                        assert wrapper != null;
                        for (Bed i : wrapper.getBed()) {
                            if (i.getPatient().getIdcode().equals(patient.getIdcode())) {
                                i.setPatient(patient);
                                break;
                            }
                        }
                        BedService.saveBed(wrapper, "src/System/data/bedlist.xml");
                        save(choice);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.primaryStage);
                    alert.setTitle("错误");
                    alert.setHeaderText("未选择对象！");
                    alert.setContentText("请选择要修改的对象！");
                    alert.showAndWait();
                }
                break;
            case 2:
                Bed bed = tableview2.getSelectionModel().getSelectedItem();
                if (bed != null) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("../fxml/BedAE.fxml"));
                    AnchorPane page = loader.load();

                    // Create the dialog Stage.
                    Stage dialogStage = new Stage();
                    dialogStage.setTitle("增加或删除成员");
                    dialogStage.initModality(Modality.WINDOW_MODAL);
                    dialogStage.initOwner(Main.primaryStage);
                    Scene scene = new Scene(page);
                    dialogStage.setScene(scene);

                    // Set the person into the controller.
                    BedAEController controller = loader.getController();
                    controller.setDialogStage(dialogStage);
                    controller.edit(bed);
                    // Show the dialog and wait until the user closes it
                    dialogStage.showAndWait();
                    //保存
                    if (controller.isOk()) {
                        save(choice);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(Main.primaryStage);
                    alert.setTitle("错误");
                    alert.setHeaderText("未选择对象！");
                    alert.setContentText("请选择要修改的对象！");
                    alert.showAndWait();
                }
                break;
            case 3:

                break;
        }

    }

    @FXML
    void menu(ActionEvent event) {
        progressbar.setVisible(true);
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(1));
        pauseTransition.setOnFinished(ev -> {
            progressbar.setVisible(false);
            if ("病患管理".equals(menu.getValue())) {
                analyze.setVisible(true);
                searchfield.setPromptText("搜索姓名");
                tableview1.setVisible(true);
                tableview2.setVisible(false);
                tableview3.setVisible(false);
                tableview4.setVisible(false);
                add.setVisible(true);
                edit.setVisible(true);
                analyze.setVisible(true);
                choice = 1;
                paData.clear();
                if (PatientService.loadPa("src/System/data/patientlist.xml") == null) {
                    paData.add(new Patient("id", "name", "2021-7-23", "1234567890", "男", "114514", "name1", "0987654321"));
                    PaListWrapper wrapper = new PaListWrapper();
                    wrapper.setPa(paData);
                    PatientService.savePa(wrapper, "src/System/data/patientlist.xml");
                    paData.clear();
                }
                PaListWrapper wrapper = PatientService.loadPa("src/System/data/patientlist.xml");
                assert wrapper != null;
                paData.addAll(wrapper.getPa());
                tableview1.setItems(paData);
                namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
                birthcol.setCellValueFactory(new PropertyValueFactory<>("birthday"));
                sexcol.setCellValueFactory(new PropertyValueFactory<>("sex"));
                epersoncol.setCellValueFactory(new PropertyValueFactory<>("emergency"));
                ephonecol.setCellValueFactory(new PropertyValueFactory<>("emerphone"));
                phonecol.setCellValueFactory(new PropertyValueFactory<>("phone"));
            } else if ("床位管理".equals(menu.getValue())) {
                analyze.setVisible(false);
                searchfield.setPromptText("搜索ID");
                tableview1.setVisible(false);
                tableview2.setVisible(true);
                tableview3.setVisible(false);
                tableview4.setVisible(false);
                add.setVisible(true);
                edit.setVisible(true);
                analyze.setVisible(false);
                choice = 2;
                bedData.clear();
                if (BedService.loadBed("src/System/data/bedlist.xml") == null) {
                    bedData.add(new Bed(new Patient("id", "name", "2021-7-23", "1234567890", "男", "114514", "name1", "0987654321"), "1号楼", "1层", "1号房", "1号床", "2021-7-22", "2021-7-23", "空闲", "1", "1"));
                    BedListWrapper wrapper = new BedListWrapper();
                    wrapper.setBed(bedData);
                    BedService.saveBed(wrapper, "src/System/data/bedlist.xml");
                    bedData.clear();
                }
                BedListWrapper wrapper = BedService.loadBed("src/System/data/bedlist.xml");
                assert wrapper != null;
                bedData.addAll(wrapper.getBed());
                tableview2.setItems(bedData);
                bidcol.setCellValueFactory(new PropertyValueFactory<>("id"));
                blocationcol.setCellValueFactory(new PropertyValueFactory<>("location"));
                bstartcol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
                bendcol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
                bstatuscol.setCellValueFactory(new PropertyValueFactory<>("status"));
                bidcodecol.setCellValueFactory(new PropertyValueFactory<>("idcode"));
                bnamecol.setCellValueFactory(cellData -> cellData.getValue().getPatient().nameProperty());
                bsexcol.setCellValueFactory(cellData -> cellData.getValue().getPatient().sexProperty());
                bagecol.setCellValueFactory(cellData -> cellData.getValue().getPatient().birthdayProperty());
            } else if ("稀有设备管理".equals(menu.getValue())) {

            } else if ("评估记录".equals(menu.getValue())) {
                tableview1.setVisible(false);
                tableview2.setVisible(false);
                tableview3.setVisible(false);
                tableview4.setVisible(true);
                add.setVisible(false);
                edit.setVisible(false);
                analyze.setVisible(false);
                choice = 4;
                aData.clear();
                if (AnalysisService.loadAnalysis("src/System/data/analysislist.xml") == null) {
                    Analysis analysis = new Analysis();
                    AnalysisWrapper wrapper = new AnalysisWrapper();
                    ObservableList<Analysis> list = FXCollections.observableArrayList();
                    list.add(analysis);
                    wrapper.setAnalysis(list);
                    AnalysisService.saveAnalysis(wrapper, "src/System/data/analysislist.xml");
                }
                AnalysisWrapper wrapper = AnalysisService.loadAnalysis("src/System/data/analysislist.xml");
                assert wrapper != null;
                aData.addAll(wrapper.getAnalysis());
                tableview4.setItems(aData);
                anamecol.setCellValueFactory(new PropertyValueFactory<>("name"));
                apnamecol.setCellValueFactory(new PropertyValueFactory<>("aperson"));
                atnamecol.setCellValueFactory(new PropertyValueFactory<>("tname"));
                asexcol.setCellValueFactory(new PropertyValueFactory<>("sex"));
                attypecol.setCellValueFactory(new PropertyValueFactory<>("ttype"));
                atimecol.setCellValueFactory(new PropertyValueFactory<>("time"));
                alevelcol.setCellValueFactory(new PropertyValueFactory<>("advice"));
            }
        });
        pauseTransition.play();
    }

    @FXML
    void search(javafx.scene.input.KeyEvent event) {
        switch (choice) {
            default:
                break;
            case 1:
                FilteredList<Patient> filter1 = new FilteredList<>(paData);
                searchfield.setOnKeyReleased(e -> {
                    searchfield.textProperty().addListener((observable, oldValue, newValue) -> {
                        filter1.setPredicate((Predicate<? super Patient>) (Patient patient) -> {
                            if (newValue == null || newValue.isEmpty()) {
                                return true;
                            } else {
                                return patient.getName().contains(newValue);
                            }
                        });
                    });
                    SortedList<Patient> sorted = new SortedList<>(filter1);
                    sorted.comparatorProperty().bind(tableview1.comparatorProperty());
                    tableview1.setItems(sorted);
                });
                break;
            case 2:
                FilteredList<Bed> filter2 = new FilteredList<>(bedData);
                searchfield.setOnKeyReleased(e -> {
                    searchfield.textProperty().addListener((observable, oldValue, newValue) -> {
                        filter2.setPredicate((Predicate<? super Bed>) (Bed bed) -> {
                            if (newValue == null || newValue.isEmpty()) {
                                return true;
                            } else {
                                return bed.getId().contains(newValue);
                            }
                        });
                    });
                    SortedList<Bed> sorted = new SortedList<>(filter2);
                    sorted.comparatorProperty().bind(tableview2.comparatorProperty());
                    tableview2.setItems(sorted);
                });
                break;
        }
    }

    @FXML
    void analyze() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/Analyze.fxml"));
        AnchorPane page1 = loader.load();
        Stage dialogStage1 = new Stage();
        dialogStage1.setTitle("评估系统");
        dialogStage1.initModality(Modality.WINDOW_MODAL);
        dialogStage1.initOwner(Main.primaryStage);
        Scene scene1 = new Scene(page1);
        dialogStage1.setScene(scene1);
        AnalyzeController controller1 = loader.getController();
        Patient patient = tableview1.getSelectionModel().getSelectedItem();
        controller1.setPatient(patient);
        controller1.setDialogStage(dialogStage1);
        dialogStage1.showAndWait();
    }


    @FXML
    void signout(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxml/Login.fxml")));
        Scene scene = new Scene(parent);
        Main.primaryStage.setScene(scene);
    }

    @FXML
    void viewbirthday(ActionEvent event) {
        birthcol.setVisible(birthday.isSelected());
    }

    @FXML
    void vieweperson(ActionEvent event) {
        epersoncol.setVisible(eperson.isSelected());
    }

    @FXML
    void viewephone(ActionEvent event) {
        ephonecol.setVisible(ephone.isSelected());
    }

    @FXML
    void viewname(ActionEvent event) {
        namecol.setVisible(name.isSelected());
    }

    @FXML
    void viewphone(ActionEvent event) {
        phonecol.setVisible(phone.isSelected());
    }

    @FXML
    void viewsex(ActionEvent event) {
        sexcol.setVisible(sex.isSelected());
    }

    public void save(int choice) {
        switch (choice) {
            case 1:
                PaListWrapper wrapper1 = new PaListWrapper();
                wrapper1.setPa(paData);
                PatientService.savePa(wrapper1, "src/System/data/patientlist.xml");
                break;
            case 2:
                BedListWrapper wrapper2 = new BedListWrapper();
                wrapper2.setBed(bedData);
                BedService.saveBed(wrapper2, "src/System/data/bedlist.xml");
                break;
            case 3:

                break;
            case 4:
                AnalysisWrapper wrapper4=new AnalysisWrapper();
                wrapper4.setAnalysis(aData);
                AnalysisService.saveAnalysis(wrapper4,"src/System/data/analysislist.xml");
            default:
                break;
        }
    }

    public void zconfirm() {
        if (isInputValid()) {
            using.setName(zname.getText());
            using.setPassword(zpassword.getText());
            using.setBirthday(zbirthday.getEditor().getText());
            using.setSpecialty(zspcialty.getText());
            using.setPhone(zphone.getText());
        }
        switch (using.getJobtitle()) {
            default:
                break;
            case "医生":
                AdmListWrapper wrapper1 = AdministratorService.loadAdm("src/System/data/administratorlist1.xml");
                assert wrapper1 != null;
                for (Administrator i : wrapper1.getAdm()) {
                    if (i.getId().equals(using.getId())) {
                        wrapper1.getAdm().remove(i);
                        wrapper1.getAdm().add(using);
                        break;
                    }
                }
                AdministratorService.saveAdm(wrapper1, "src/System/data/administratorlist1.xml");
                break;
            case "护士":
                AdmListWrapper wrapper2 = AdministratorService.loadAdm("src/System/data/administratorlist2.xml");
                assert wrapper2 != null;
                for (Administrator i : wrapper2.getAdm()) {
                    if (i.getId().equals(using.getId())) {
                        wrapper2.getAdm().remove(i);
                        wrapper2.getAdm().add(using);
                        break;
                    }
                }
                AdministratorService.saveAdm(wrapper2, "src/System/data/administratorlist2.xml");
                break;
            case "护工":
                AdmListWrapper wrapper3 = AdministratorService.loadAdm("src/System/data/administratorlist3.xml");
                assert wrapper3 != null;
                for (Administrator i : wrapper3.getAdm()) {
                    if (i.getId().equals(using.getId())) {
                        wrapper3.getAdm().remove(i);
                        wrapper3.getAdm().add(using);
                        break;
                    }
                }
                AdministratorService.saveAdm(wrapper3, "src/System/data/administratorlist3.xml");
                break;
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (zname.getText() == null || zname.getText().length() == 0) {
            errorMessage += "非法姓名!\n";
        }
        if (zpassword.getText() == null || zpassword.getText().length() == 0) {
            errorMessage += "非法密码\n";
        }
        if (zphone.getText() == null || zphone.getText().length() == 0) {
            errorMessage += "非法电话号码!\n";
        } else {
            try {
                Long.parseLong(zphone.getText());
            } catch (NumberFormatException e) {
                errorMessage += "电话号码必须是数字!\n";
            }
        }
        if (zbirthday.toString() == null || zbirthday.toString().length() == 0) {
            errorMessage += "非法生日!\n";
        }
        if (zspcialty.getText() == null || zspcialty.getText().length() == 0) {
            errorMessage += "非法专长!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("错误");
            alert.setHeaderText("请检查以下信息是否正确");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }


    @FXML
    void tadd(ActionEvent event) throws IOException {
        Template template = new Template();
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/TemplateAE.fxml"));
        AnchorPane page1 = loader.load();

        // Create the dialog Stage.
        Stage dialogStage1 = new Stage();
        dialogStage1.setTitle("添加模板");
        dialogStage1.initModality(Modality.WINDOW_MODAL);
        dialogStage1.initOwner(Main.primaryStage);
        Scene scene1 = new Scene(page1);
        dialogStage1.setScene(scene1);

        // Set the person into the controller.
        TemplateAEController controller1 = loader.getController();
        controller1.setDialogStage(dialogStage1);
        controller1.add(template);
        // Show the dialog and wait until the user closes it
        dialogStage1.showAndWait();
        //保存
        if (controller1.isOk()) {
            tData.add(template);
            TemplateWrapper wrapper1 = new TemplateWrapper();
            wrapper1.setTemplate(tData);
            TemplateService.saveTemplate(wrapper1, "src/System/data/templatelist.xml");
        }
    }

    @FXML
    void tdelete(ActionEvent event) {
        int selectedIndex1 = ttableview.getSelectionModel().getSelectedIndex();
        if (selectedIndex1 >= 0) {
            ttableview.getItems().remove(selectedIndex1);
            TemplateWrapper wrapper1 = new TemplateWrapper();
            wrapper1.setTemplate(tData);
            TemplateService.saveTemplate(wrapper1, "src/System/data/templatelist.xml");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.primaryStage);
            alert.setTitle("错误");
            alert.setHeaderText("未选择对象！");
            alert.setContentText("请选择要删除的对象！");
            alert.showAndWait();
        }
    }

    @FXML
    void tdetails(ActionEvent event) throws IOException {
        Template template = ttableview.getSelectionModel().getSelectedItem();
        if (template != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../fxml/TemplateDetails.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("查看详情");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            TemplateDetailsController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.detail(template);
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.primaryStage);
            alert.setTitle("错误");
            alert.setHeaderText("未选择对象！");
            alert.setContentText("请选择要查看的对象！");
            alert.showAndWait();
        }
    }

    @FXML
    void tedit(ActionEvent event) throws IOException {
        Template template = ttableview.getSelectionModel().getSelectedItem();
        if (template != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../fxml/TemplateAE.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("编辑模板");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            TemplateAEController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.edit(template);
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            //保存
            if (controller.isOk()) {
                TemplateWrapper wrapper1 = new TemplateWrapper();
                wrapper1.setTemplate(tData);
                TemplateService.saveTemplate(wrapper1, "src/System/data/templatelist.xml");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.primaryStage);
            alert.setTitle("错误");
            alert.setHeaderText("未选择对象！");
            alert.setContentText("请选择要修改的对象！");
            alert.showAndWait();
        }
    }


    @FXML
    void tsearch(javafx.scene.input.KeyEvent event) {
        FilteredList<Template> filter1 = new FilteredList<>(tData);
        searchfield.setOnKeyReleased(e -> {
            searchfield.textProperty().addListener((observable, oldValue, newValue) -> {
                filter1.setPredicate((Predicate<? super Template>) (Template template) -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    } else {
                        return template.getId().contains(newValue);
                    }
                });
            });
            SortedList<Template> sorted = new SortedList<>(filter1);
            sorted.comparatorProperty().bind(ttableview.comparatorProperty());
            ttableview.setItems(sorted);
        });
    }

    void tflash() {
        tData.clear();
        if (TemplateService.loadTemplate("src/System/data/templatelist.xml") == null) {
            tData.add(new Template("1", "模板一", "A", new Question("1", "示例问题", "示例选项1", "示例选项2", "示例选项3", "A"), new Question("1", "示例问题", "示例选项1", "示例选项2", "示例选项3", "A"), new Question("1", "示例问题", "示例选项1", "示例选项2", "示例选项3", "A")));
            TemplateWrapper twrapper = new TemplateWrapper();
            twrapper.setTemplate(tData);
            TemplateService.saveTemplate(twrapper, "src/System/data/templatelist.xml");
            tData.clear();
        }
        TemplateWrapper twrapper = TemplateService.loadTemplate("src/System/data/templatelist.xml");
        assert twrapper != null;
        tData.addAll(twrapper.getTemplate());
        ttableview.setItems(tData);
        tidcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        tnamecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ttypecol.setCellValueFactory(new PropertyValueFactory<>("type"));
    }

    @FXML
    void qadd(ActionEvent event) throws IOException {
        Question question = new Question();
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/QuestionAE.fxml"));
        AnchorPane page1 = loader.load();

        // Create the dialog Stage.
        Stage dialogStage1 = new Stage();
        dialogStage1.setTitle("添加问题");
        dialogStage1.initModality(Modality.WINDOW_MODAL);
        dialogStage1.initOwner(Main.primaryStage);
        Scene scene1 = new Scene(page1);
        dialogStage1.setScene(scene1);

        // Set the person into the controller.
        QuestionAEController controller1 = loader.getController();
        controller1.setDialogStage(dialogStage1);
        controller1.add(question);
        // Show the dialog and wait until the user closes it
        dialogStage1.showAndWait();
        //保存
        if (controller1.isOk()) {
            qData.add(question);
            QuestionWrapper wrapper1 = new QuestionWrapper();
            wrapper1.setQuestion(qData);
            QuestionService.saveQuestion(wrapper1, "src/System/data/questionlist.xml");
        }
    }

    @FXML
    public void qdelete(ActionEvent event) {
        int selectedIndex1 = qtableview.getSelectionModel().getSelectedIndex();
        if (selectedIndex1 >= 0) {
            TemplateWrapper wrapper = TemplateService.loadTemplate("src/System/data/templatelist.xml");
            assert wrapper != null;
            for (Template i : wrapper.getTemplate()) {
                if (i.getQ1().getId().equals(qtableview.getSelectionModel().getSelectedItem().getId()) ||
                        i.getQ2().getId().equals(qtableview.getSelectionModel().getSelectedItem().getId()) ||
                        i.getQ3().getId().equals(qtableview.getSelectionModel().getSelectedItem().getId())) {
                    wrapper.getTemplate().remove(i);
                    break;
                }
            }
            qtableview.getItems().remove(selectedIndex1);
            TemplateService.saveTemplate(wrapper, "src/System/data/templatelist.xml");
            tflash();
            QuestionWrapper wrapper1 = new QuestionWrapper();
            wrapper1.setQuestion(qData);
            QuestionService.saveQuestion(wrapper1, "src/System/data/questionlist.xml");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.primaryStage);
            alert.setTitle("错误");
            alert.setHeaderText("未选择对象！");
            alert.setContentText("请选择要删除的对象！");
            alert.showAndWait();
        }


    }


    @FXML
    public void qedit(ActionEvent event) throws IOException {
        Question question = qtableview.getSelectionModel().getSelectedItem();
        if (question != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../fxml/QuestionAE.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("编辑问题");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            QuestionAEController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.edit(question);
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            //保存
            if (controller.isOk()) {
                TemplateWrapper wrapper = TemplateService.loadTemplate("src/System/data/Templatelist.xml");
                assert wrapper != null;
                for (Template i : wrapper.getTemplate()) {
                    if (i.getQ1().getId().equals(question.getId())) {
                        i.setQ1(question);
                        break;
                    } else if (i.getQ2().getId().equals(question.getId())) {
                        i.setQ2(question);
                        break;
                    } else if (i.getQ3().getId().equals(question.getId())) {
                        i.setQ3(question);
                        break;
                    }
                }
                TemplateService.saveTemplate(wrapper, "src/System/data/templatelist.xml");
                tflash();
                QuestionWrapper wrapper1 = new QuestionWrapper();
                wrapper1.setQuestion(qData);
                QuestionService.saveQuestion(wrapper1, "src/System/data/questionlist.xml");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.primaryStage);
            alert.setTitle("错误");
            alert.setHeaderText("未选择对象！");
            alert.setContentText("请选择要修改的对象！");
            alert.showAndWait();
        }
    }

    @FXML
    public void qsearch(javafx.scene.input.KeyEvent event) {
        /*searchfield.setOnKeyReleased(e -> {*/
        searchfield.textProperty().addListener((observable, oldValue, newValue) -> {
            filterq.setPredicate((Predicate<? super Question>) (Question question) -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                } else {
                    return question.getId().contains(newValue);
                }
            });
        });
        SortedList<Question> sorted = new SortedList<>(filterq);
        sorted.comparatorProperty().bind(qtableview.comparatorProperty());
        qtableview.setItems(sorted);
        System.out.println("ok");
        /*});*/
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        progressbar.setVisible(false);

        ToolsService.showtime(timeInfoLabel);
        //初始化JFXComboBox
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "病患管理",
                        "床位管理",
                        "评估记录"
                );
        menu.setItems(options);

        //初始化账号设置
        zname.setText(using.getName());
        zbirthday.getEditor().setText(using.getBirthday());
        zspcialty.setText(using.getSpecialty());
        zphone.setText(using.getPhone());
        zpassword.setText(using.getPassword());

        usingtext.setText(String.format("当前账号：%s", using.getId()));
        //初始化patient

        if (PatientService.loadPa("src/System/data/patientlist.xml") == null) {
            paData.add(new Patient("id", "name", "2021-7-23", "1234567890", "男", "114514", "name1", "0987654321"));
            PaListWrapper wrapper = new PaListWrapper();
            wrapper.setPa(paData);
            PatientService.savePa(wrapper, "src/System/data/patientlist.xml");
            paData.clear();
        }
        PaListWrapper wrapper = PatientService.loadPa("src/System/data/patientlist.xml");
        assert wrapper != null;
        paData.addAll(wrapper.getPa());
        tableview1.setItems(paData);
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        birthcol.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        sexcol.setCellValueFactory(new PropertyValueFactory<>("sex"));
        epersoncol.setCellValueFactory(new PropertyValueFactory<>("emergency"));
        ephonecol.setCellValueFactory(new PropertyValueFactory<>("emerphone"));
        phonecol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        //初始化Question
        if (QuestionService.loadQuestion("src/System/data/questionlist.xml") == null) {
            qData.add(new Question("1", "示例问题", "示例选项1", "示例选项2", "示例选项3", "A"));
            QuestionWrapper qwrapper = new QuestionWrapper();
            qwrapper.setQuestion(qData);
            QuestionService.saveQuestion(qwrapper, "src/System/data/questionlist.xml");
            qData.clear();
        }
        QuestionWrapper qwrapper = QuestionService.loadQuestion("src/System/data/questionlist.xml");
        assert qwrapper != null;
        qData.addAll(qwrapper.getQuestion());
        qtableview.setItems(qData);
        qidcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        qtextcol.setCellValueFactory(new PropertyValueFactory<>("text"));
        qtypecol.setCellValueFactory(new PropertyValueFactory<>("type"));
        //初始化Template
        tflash();
    }
}


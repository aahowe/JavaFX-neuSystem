package System.view.controller;

import System.model.Administrator;
import System.service.AdmListWrapper;
import System.Main;

import System.service.AdministratorService;
import com.jfoenix.controls.*;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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


/**
 * @author wanghao
 */
public class AdminController implements Initializable {

    @FXML
    private AnchorPane admin;

    @FXML
    private JFXComboBox<String> menu;

    @FXML
    private JFXToggleButton id;

    @FXML
    private JFXToggleButton name;

    @FXML
    private JFXToggleButton birthday;

    @FXML
    private JFXToggleButton jobtitle;

    @FXML
    private JFXToggleButton specialty;

    @FXML
    private JFXToggleButton phone;

    @FXML
    private JFXProgressBar progressbar;

    @FXML
    private JFXTextField searchfield;

    @FXML
    private TableView<Administrator> tableview;

    @FXML
    private TableColumn<Administrator, String> idcol;

    @FXML
    private TableColumn<Administrator, String> namecol;

    @FXML
    private TableColumn<Administrator, String> birthdaycol;

    @FXML
    private TableColumn<Administrator, String> specialtycol;

    @FXML
    private TableColumn<Administrator, String> jobtitlecol;

    @FXML
    private TableColumn<Administrator, String> phonecol;

    private ObservableList<Administrator> admData = FXCollections.observableArrayList();

    private FilteredList<Administrator> filter = new FilteredList<>(admData);
    int choice = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        progressbar.setVisible(false);

        //?????????JFXComboBox
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "??????",
                        "??????",
                        "??????"
                );
        menu.setItems(options);

        //?????????tableview

        if (AdministratorService.loadAdm("src/System/data/administratorlist1.xml") == null) {
            admData.add(new Administrator("id", "name", "2021-7-23", "1234567890", "specialty", "??????", "password"));
            AdmListWrapper wrapper = new AdmListWrapper();
            wrapper.setAdm(admData);
            AdministratorService.saveAdm(wrapper, "src/System/data/administratorlist1.xml");
        }

        AdmListWrapper wrapper = AdministratorService.loadAdm("src/System/data/administratorlist1.xml");
        assert wrapper != null;
        admData.addAll(wrapper.getAdm());

        tableview.setItems(admData);
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        birthdaycol.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        specialtycol.setCellValueFactory(new PropertyValueFactory<>("specialty"));
        jobtitlecol.setCellValueFactory(new PropertyValueFactory<>("jobtitle"));
        phonecol.setCellValueFactory(new PropertyValueFactory<>("phone"));

    }

    @FXML
    public void search(javafx.scene.input.KeyEvent event) {
        searchfield.setOnKeyReleased(e -> {
            searchfield.textProperty().addListener((observable, oldValue, newValue) -> {
                filter.setPredicate((Predicate<? super Administrator>) (Administrator adm) -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    } else {
                        return adm.getId().contains(newValue);
                    }
                });
            });
            SortedList<Administrator> sorted = new SortedList<>(filter);
            sorted.comparatorProperty().bind(tableview.comparatorProperty());
            tableview.setItems(sorted);
        });

    }


    @FXML
    public void viewid() {
        idcol.setVisible(id.isSelected());
    }

    @FXML
    public void viewname() {
        namecol.setVisible(name.isSelected());
    }

    @FXML
    public void viewbirth() {
        birthdaycol.setVisible(birthday.isSelected());
    }

    @FXML
    public void viewtitle() {
        jobtitlecol.setVisible(jobtitle.isSelected());
    }

    @FXML
    public void viewspc() {
        specialtycol.setVisible(specialty.isSelected());
    }

    @FXML
    public void viewphone() {
        phonecol.setVisible(phone.isSelected());
    }

    @FXML
    public void signout() throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxml/Login.fxml")));
        Scene scene = new Scene(parent);
        Main.primaryStage.setScene(scene);
    }

    @FXML
    public void menu() {
        progressbar.setVisible(true);
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(1));
        pauseTransition.setOnFinished(ev -> {
            progressbar.setVisible(false);
            if ("??????".equals(menu.getValue())) {
                choice = 1;
                admData.clear();
                if (AdministratorService.loadAdm("src/System/data/administratorlist1.xml") == null) {
                    admData.add(new Administrator("id", "name", "2021-7-23", "1234567890", "specialty", "??????", "password"));
                    AdmListWrapper wrapper = new AdmListWrapper();
                    wrapper.setAdm(admData);
                    AdministratorService.saveAdm(wrapper, "src/System/data/administratorlist1.xml");
                    admData.clear();
                }
                AdmListWrapper wrapper = AdministratorService.loadAdm("src/System/data/administratorlist1.xml");
                assert wrapper != null;
                admData.addAll(wrapper.getAdm());
                tableview.setItems(admData);
                idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
                namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
                birthdaycol.setCellValueFactory(new PropertyValueFactory<>("birthday"));
                specialtycol.setCellValueFactory(new PropertyValueFactory<>("specialty"));
                jobtitlecol.setCellValueFactory(new PropertyValueFactory<>("jobtitle"));
                phonecol.setCellValueFactory(new PropertyValueFactory<>("phone"));
            } else if ("??????".equals(menu.getValue())) {
                choice = 2;
                admData.clear();
                if (AdministratorService.loadAdm("src/System/data/administratorlist2.xml") == null) {
                    admData.add(new Administrator("id", "name", "2021-7-23", "1234567890", "specialty", "??????", "password"));
                    AdmListWrapper wrapper = new AdmListWrapper();
                    wrapper.setAdm(admData);
                    AdministratorService.saveAdm(wrapper, "src/System/data/administratorlist2.xml");
                    admData.clear();
                }
                AdmListWrapper wrapper = AdministratorService.loadAdm("src/System/data/administratorlist2.xml");
                assert wrapper != null;
                admData.addAll(wrapper.getAdm());
                tableview.setItems(admData);
                idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
                namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
                birthdaycol.setCellValueFactory(new PropertyValueFactory<>("birthday"));
                specialtycol.setCellValueFactory(new PropertyValueFactory<>("specialty"));
                jobtitlecol.setCellValueFactory(new PropertyValueFactory<>("jobtitle"));
                phonecol.setCellValueFactory(new PropertyValueFactory<>("phone"));
            } else if ("??????".equals(menu.getValue())) {
                choice = 3;
                admData.clear();
                if (AdministratorService.loadAdm("src/System/data/administratorlist3.xml") == null) {
                    admData.add(new Administrator("id", "name", "2021-7-23", "1234567890", "specialty", "??????", "password"));
                    AdmListWrapper wrapper = new AdmListWrapper();
                    wrapper.setAdm(admData);
                    AdministratorService.saveAdm(wrapper, "src/System/data/administratorlist3.xml");
                    admData.clear();
                }
                AdmListWrapper wrapper = AdministratorService.loadAdm("src/System/data/administratorlist3.xml");
                assert wrapper != null;
                admData.addAll(wrapper.getAdm());
                tableview.setItems(admData);
                idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
                namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
                birthdaycol.setCellValueFactory(new PropertyValueFactory<>("birthday"));
                specialtycol.setCellValueFactory(new PropertyValueFactory<>("specialty"));
                jobtitlecol.setCellValueFactory(new PropertyValueFactory<>("jobtitle"));
                phonecol.setCellValueFactory(new PropertyValueFactory<>("phone"));
            }
        });
        pauseTransition.play();
    }

    @FXML
    public void add() throws IOException {
        Administrator adm = new Administrator();
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/AdminAE.fxml"));
        AnchorPane page = loader.load();

        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("?????????????????????");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(Main.primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Set the person into the controller.
        AdminAEController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setChoice(choice);
        controller.add(adm);
        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();
        //??????
        if (controller.isOk()) {
            admData.add(adm);
            save(choice);
        }
    }

    @FXML
    public void edit() throws IOException {
        Administrator adm = tableview.getSelectionModel().getSelectedItem();
        if (adm != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../fxml/AdminAE.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("?????????????????????");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AdminAEController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setChoice(choice);
            controller.edit(adm);
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            //??????
            if (controller.isOk()) {
                save(choice);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.primaryStage);
            alert.setTitle("??????");
            alert.setHeaderText("??????????????????");
            alert.setContentText("??????????????????????????????");
            alert.showAndWait();
        }

    }

    @FXML
    public void delete() {
        int selectedIndex = tableview.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tableview.getItems().remove(selectedIndex);
            save(choice);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.primaryStage);
            alert.setTitle("??????");
            alert.setHeaderText("??????????????????");
            alert.setContentText("??????????????????????????????");
            alert.showAndWait();
        }
    }

    public void save(int choice) {
        AdmListWrapper wrapper = new AdmListWrapper();
        wrapper.setAdm(admData);
        switch (choice) {
            case 1:
                AdministratorService.saveAdm(wrapper, "src/System/data/administratorlist1.xml");
                break;
            case 2:
                AdministratorService.saveAdm(wrapper, "src/System/data/administratorlist2.xml");
                break;
            case 3:
                AdministratorService.saveAdm(wrapper, "src/System/data/administratorlist3.xml");
                break;
            default:
                break;
        }
    }
}

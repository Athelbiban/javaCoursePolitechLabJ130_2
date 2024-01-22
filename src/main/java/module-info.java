module lab.javacoursepolitechlabj130_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens lab.javacoursepolitechlabj130_2 to javafx.fxml;
    exports lab.javacoursepolitechlabj130_2;
}
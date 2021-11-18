import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {
    private JPanel mainPanel;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JButton button;
    private JTextArea textArea1;
    private JLabel lab1;

    public MainForm(){
        button.addActionListener(new Action() {
            @Override
            public Object getValue(String s) {
                return null;
            }

            @Override
            public void putValue(String s, Object o) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {

            }

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(button.getText().equals("Expand")){
                    textArea1.setText("");
                    textArea2.setText("");
                    textArea3.setText("(необязательно)");
                    lab1.setText("");
                    button.setText("Collapse");
                }
                if(!textArea1.getText().equals("") && !textArea2.getText().equals("") && button.getText().equals("Collapse")){
                    if(textArea3.getText().equals("(необязательно)") || textArea3.getText().equals("")){
                        lab1.setText(textArea1.getText() + " " + textArea2.getText());
                        button.setText("Expand");
                    }else {
                        lab1.setText(textArea1.getText() + " " + textArea2.getText() + " " + textArea3.getText());
                        button.setText("Expand");
                    }
                }
            }
        });
    }

    public JPanel getMainPanel(){

        return mainPanel;
    }
}

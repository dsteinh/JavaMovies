/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Person;
import hr.algebra.utils.MessageUtils;
import hr.algebra.view.model.PersonTableModel;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Dodo
 */
public class EditPersonPanel extends javax.swing.JPanel {

    private List<JTextComponent> validationFields;
    private List<JLabel> errorLabels;

    private Repository repository;
    private PersonTableModel personTableModel;

    private Person selectedPerson;

    /**
     * Creates new form EditPersonPanel
     */
    public EditPersonPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        txtFirstName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPeople = new javax.swing.JTable();
        lblLName = new javax.swing.JLabel();
        lblFName = new javax.swing.JLabel();

        popupMenu1.setLabel("popupMenu1");

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tblPeople.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPeople.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeopleMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblPeople);

        lblLName.setForeground(new java.awt.Color(255, 0, 0));

        lblFName.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstName)
                            .addComponent(txtLastName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblLName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(593, 593, 593))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addContainerGap(409, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(336, 336, 336)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (formValid()) {
            try {
                Person person = new Person();

                person.setFirstName(txtFirstName.getText().trim());
                person.setLastName(txtLastName.getText().trim());

                repository.createActor(person);
                personTableModel.setPerson(repository.selectActors());

                clearForm();
                MessageUtils.showInformationMessage("Info", "Sucsess");
            } catch (Exception ex) {
                Logger.getLogger(EditMoviePanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to update movie!");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedPerson == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose person to update");
            return;
        }
        if (formValid()) {

            selectedPerson.setFirstName(txtFirstName.getText().trim());
            selectedPerson.setLastName(txtLastName.getText().trim());
            try {
                repository.updatePerson(selectedPerson.getId(), selectedPerson);
            } catch (Exception ex) {
                Logger.getLogger(EditPersonPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showInformationMessage("Err", "Unexpected error");
            }

            try {
                personTableModel.setPerson(repository.selectActors());
            } catch (Exception ex) {
                Logger.getLogger(EditPersonPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showInformationMessage("Err", "Unexpected error");
            }

            clearForm();
            MessageUtils.showInformationMessage("Info", "Sucsess");

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (selectedPerson == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose actor to delete");
            return;
        }
        int res = MessageUtils.showConfirmDialog("Confirm", "Do you really want to delete data?");
        if (res == JOptionPane.YES_OPTION) {
            try {
                repository.deleteActor(selectedPerson);
                personTableModel.setPerson(repository.selectActors());
                MessageUtils.showInformationMessage("Info", "Data deleted successfully");
            } catch (Exception ex) {
                Logger.getLogger(EditMoviePanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showInformationMessage("Error", "Error while deleting");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblPeopleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeopleMouseClicked
        showPerson();
    }//GEN-LAST:event_tblPeopleMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            init();
        } catch (Exception ex) {
            Logger.getLogger(EditPersonPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblFName;
    private javax.swing.JLabel lblLName;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTable tblPeople;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables

    private void init() throws Exception {
        initRepository();
        initValidation();
        initTable();
    }

    private void initTable() throws Exception {
        tblPeople.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblPeople.setAutoCreateRowSorter(true);
        tblPeople.setRowHeight(25);
        personTableModel = new PersonTableModel(repository.selectActors());
        tblPeople.setModel(personTableModel);
    }

    private void initValidation() {
        validationFields = Arrays.asList(txtFirstName, txtLastName);
        errorLabels = Arrays.asList(lblFName, lblLName);
    }

    private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }

    private boolean formValid() {
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setText(validationFields.get(i).getText().trim().isEmpty() ? "X" : "");
        }

        return ok;
    }

    private void showPerson() {
        clearForm();
        int selectedRow = tblPeople.getSelectedRow();
        int rowIndex = tblPeople.convertRowIndexToModel(selectedRow);
        int selectedPersonId = (int) personTableModel.getValueAt(rowIndex, 0);

        try {
            Optional<Person> optPerson = repository.selectActors(selectedPersonId);
            if (optPerson.isPresent()) {
                selectedPerson = optPerson.get();
                fillForm(selectedPerson);

            }
        } catch (Exception ex) {
            Logger.getLogger(EditMoviePanel.class
                    .getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to show movie!");
        }
    }

    private void clearForm() {
        validationFields.forEach(e -> e.setText(""));
        errorLabels.forEach(e -> e.setText(""));
        selectedPerson = null;
    }

    private void fillForm(Person person) {
        txtFirstName.setText(person.getFirstName());
        txtLastName.setText(person.getLastName());
    }
}
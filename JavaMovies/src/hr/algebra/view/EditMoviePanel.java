/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Movie;
import hr.algebra.model.PersonTransferable;
import hr.algebra.model.Person;
import hr.algebra.utils.FileUtils;
import hr.algebra.utils.IconUtils;
import hr.algebra.utils.MessageUtils;
import hr.algebra.view.model.MovieTableModel;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Dodo
 */
public class EditMoviePanel extends javax.swing.JPanel {

    private List<JTextComponent> validationFields;
    private List<JLabel> errorLabels;

    private static final String DIR = "assets";

    private Repository repository;
    private MovieTableModel movieTableModel;

    private Movie selectedMovie;

    /**
     * Creates new form EditMoviePanel
     */
    public EditMoviePanel() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblIcon = new javax.swing.JLabel();
        btnChoose = new javax.swing.JButton();
        txtTitle = new javax.swing.JTextField();
        txtImgPath = new javax.swing.JTextField();
        cbDirector = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPlot = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlAllActors = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlActors = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMovies = new javax.swing.JTable();
        lblPlotErr = new javax.swing.JLabel();
        lblTitleErr = new javax.swing.JLabel();
        lblImgErr = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 720));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Plot");

        jLabel2.setText("Title");

        jLabel3.setText("Director");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png"))); // NOI18N

        btnChoose.setText("Choose");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        txtImgPath.setEditable(false);

        cbDirector.setToolTipText("");

        txtPlot.setColumns(20);
        txtPlot.setLineWrap(true);
        txtPlot.setRows(5);
        jScrollPane1.setViewportView(txtPlot);

        jScrollPane2.setViewportView(jlAllActors);

        jLabel5.setText("All Actors");

        jlActors.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jlActors.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jlActorsKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jlActors);

        jLabel6.setText("Actors");

        tblMovies.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMoviesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblMovies);

        lblPlotErr.setForeground(new java.awt.Color(255, 51, 0));

        lblTitleErr.setForeground(new java.awt.Color(255, 51, 0));

        lblImgErr.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(lblPlotErr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(518, 518, 518)
                                .addComponent(lblTitleErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtImgPath, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChoose)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblImgErr, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChoose)
                            .addComponent(txtImgPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(288, 288, 288)
                                .addComponent(lblImgErr, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblTitleErr, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addComponent(lblPlotErr, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd)
                            .addComponent(btnUpdate))
                        .addGap(13, 13, 13)
                        .addComponent(btnDelete)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (formValid()) {
            try {
                Movie movie = new Movie();

                String localPicturePath = uploadPicture();
                movie.setImagePath(localPicturePath);
                movie.setTitle(txtTitle.getText().trim());
                movie.setPlot(txtPlot.getText().trim());
                movie.setDirector(((Person) cbDirector.getSelectedItem()));
                movie.setDirectorId(((Person) (cbDirector.getSelectedItem())).getId());
                movie.setActros(getItemsFromJList(jlActors));
                movie.setImagePath(txtImgPath.getText().trim());

                repository.createMovie(movie);
                movieTableModel.setMovies(repository.selectMovies());

                clearForm();
                MessageUtils.showInformationMessage("Info", "Sucsess");
            } catch (Exception ex) {
                Logger.getLogger(EditMoviePanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to update movie!");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown

    private void tblMoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMoviesMouseClicked
        showMovie();
    }//GEN-LAST:event_tblMoviesMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedMovie == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose movie to update");
            return;
        }
        if (formValid()) {
            try {
                if (!txtImgPath.getText().trim().equals(selectedMovie.getImagePath())) {
                    if (selectedMovie.getImagePath() != null) {
                        Files.deleteIfExists(Paths.get(selectedMovie.getImagePath()));
                    }
                    String localPicturePath = uploadPicture();
                    selectedMovie.setImagePath(localPicturePath);
                }

                selectedMovie.setTitle(txtTitle.getText().trim());
                selectedMovie.setPlot(txtPlot.getText().trim());
                selectedMovie.setDirector(((Person) cbDirector.getSelectedItem()));
                selectedMovie.setDirectorId(selectedMovie.getDirector().getId());
                selectedMovie.setActros(getItemsFromJList(jlActors));
                selectedMovie.setImagePath(txtImgPath.getText().trim());
                repository.updateMovie(selectedMovie.getId(), selectedMovie);

                movieTableModel.setMovies(repository.selectMovies());

                clearForm();
                MessageUtils.showInformationMessage("Info", "Sucsess");
            } catch (Exception ex) {
                Logger.getLogger(EditMoviePanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to update movie!");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        File file = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");
        if (file == null) {
            return;
        }
        txtImgPath.setText(file.getAbsolutePath());
        setIcon(lblIcon, file);
    }//GEN-LAST:event_btnChooseActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (selectedMovie == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose movie to delete");
            return;
        }
        int res = MessageUtils.showConfirmDialog("Confirm", "Do you really want to delete all data?");
        if (res == JOptionPane.YES_OPTION) {
            try {
                repository.deleteMovie(selectedMovie);
                FileUtils.deleteFile(selectedMovie.getImagePath());
                movieTableModel.setMovies(repository.selectMovies());
                MessageUtils.showInformationMessage("Info", "Data deleted successfully");
            } catch (Exception ex) {
                Logger.getLogger(EditMoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jlActorsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jlActorsKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            DefaultListModel model = (DefaultListModel) jlActors.getModel();
            int selectedIndex = jlActors.getSelectedIndex();
            if (selectedIndex != -1) {
                model.remove(selectedIndex);
            }
            try {
                initLists(getItemsFromJList(jlActors), jlActors);
            } catch (Exception ex) {
                Logger.getLogger(EditMoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jlActorsKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Person> cbDirector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<Person> jlActors;
    private javax.swing.JList<Person> jlAllActors;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblImgErr;
    private javax.swing.JLabel lblPlotErr;
    private javax.swing.JLabel lblTitleErr;
    private javax.swing.JTable tblMovies;
    private javax.swing.JTextField txtImgPath;
    private javax.swing.JTextArea txtPlot;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
  private void init() {
        try {
            initValidation();
            initRepository();
            initTable();
            initCbDirectors();
            initLists(repository.selectActors(), jlAllActors);
            initDragNDrop();

        } catch (Exception ex) {
            Logger.getLogger(EditMoviePanel.class
                    .getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void initLists(List<Person> list, JList jList) throws Exception {
        DefaultListModel<Person> sourceModel = new DefaultListModel<>();

        list.forEach(sourceModel::addElement);
        jList.setModel(sourceModel);
//        sourceModel = new DefaultListModel<>();
//        repository.selectActors()
//                .forEach(sourceModel::addElement);
//        jlAllActors.setModel(sourceModel);

    }

    private void initValidation() {
        validationFields = Arrays.asList(txtTitle, txtPlot, txtImgPath);
        errorLabels = Arrays.asList(lblTitleErr, lblPlotErr, lblImgErr);
    }

    private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }

    private void initTable() throws Exception {
        tblMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblMovies.setAutoCreateRowSorter(true);
        tblMovies.setRowHeight(25);
        movieTableModel = new MovieTableModel(repository.selectMovies());
        tblMovies.setModel(movieTableModel);
    }

    private void fillForm(Movie movie) throws Exception {
        if (movie.getImagePath() != null && Files.exists(Paths.get(movie.getImagePath()))) {
            txtImgPath.setText(movie.getImagePath());
            setIcon(lblIcon, new File(movie.getImagePath()));
        }
        txtTitle.setText(movie.getTitle());
        txtPlot.setText(movie.getPlot());
        cbDirector.setSelectedItem(repository.selectDirectorById(selectedMovie.getDirectorId()).get());
        initLists(repository.selectActorsByMovieId(selectedMovie.getId()), jlActors);
        //initLists(repository.selectActors(), jlAllActors);

//        setActors(movie);
//        setAllActors();
    }

    private void setIcon(JLabel label, File file) {
        try {
            label.setIcon(IconUtils.createIcon(file, label.getWidth(), label.getHeight()));

        } catch (IOException ex) {
            Logger.getLogger(EditMoviePanel.class
                    .getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to set icon!");
        }
    }

    public void showMovie() {
        clearForm();
        movies.clear();
        int selectedRow = tblMovies.getSelectedRow();
        int rowIndex = tblMovies.convertRowIndexToModel(selectedRow);
        int selectedMovieId = (int) movieTableModel.getValueAt(rowIndex, 0);

        try {
            Optional<Movie> optMovie = repository.selectMovie(selectedMovieId);
            if (optMovie.isPresent()) {
                selectedMovie = optMovie.get();
                fillForm(selectedMovie);

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
        cbDirector.setSelectedIndex(-1);
        jlActors.setModel(new DefaultListModel());
        lblIcon.setIcon(new ImageIcon(getClass().getResource("/assets/no_image.png")));

        selectedMovie = null;
    }

    private boolean formValid() {
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setText(validationFields.get(i).getText().trim().isEmpty() ? "X" : "");
        }

        return ok;
    }

    private void initCbDirectors() throws Exception {

        repository.selectMovies().forEach(m -> {
            try {
                cbDirector.addItem(repository.selectDirectorById(m.getDirectorId()).get());

            } catch (Exception ex) {
                Logger.getLogger(EditMoviePanel.class
                        .getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Can't fill cbDirectors");
            }
        });
        cbDirector.setSelectedIndex(-1);
    }

    private String uploadPicture() throws IOException {
        String picturePath = txtImgPath.getText().trim();
        String ext = picturePath.substring(picturePath.lastIndexOf("."));
        String pictureName = UUID.randomUUID() + ext;
        String localPicturePath = DIR + File.separator + pictureName;
        FileUtils.copy(picturePath, localPicturePath);
        return localPicturePath;
    }

    private List<Person> getItemsFromJList(JList<Person> list) {
        List<Person> actors = new LinkedList();
        for (int i = 0; i < list.getModel().getSize(); i++) {
            actors.add(list.getModel().getElementAt(i));
        }
        return actors;
    }

    private void initDragNDrop() {
        jlAllActors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlAllActors.setDragEnabled(true);
        jlAllActors.setTransferHandler(new ExportTransferHandler());

        jlActors.setDropMode(DropMode.ON);
        jlActors.setTransferHandler(new ImportTransferHandler());

    }

    private class ExportTransferHandler extends TransferHandler {

        @Override
        public int getSourceActions(JComponent c) {
            // defines icon shown in target before drop
            return COPY;
            //return MOVE;
        }

        @Override
        public Transferable createTransferable(JComponent c) {
            return new PersonTransferable(jlAllActors.getSelectedValue());
        }
    }
    private final List<Person> movies = new LinkedList();

    private class ImportTransferHandler extends TransferHandler {

        // we define whether we can import stringFlavor that we need for JList<String>
        @Override
        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(PersonTransferable.PERSON_FLAVOR);
        }

        // we import the data
        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            Transferable transferable = support.getTransferable();
            try {
                Person data = (Person) transferable.getTransferData(PersonTransferable.PERSON_FLAVOR);
                if (movies.add(data)) {
                    List<Person> actorsInList = getItemsFromJList(jlActors);
                    actorsInList.addAll(movies);
                    jlActors.setModel(new DefaultListModel());
                    movies.clear();
                    initLists(actorsInList, jlActors);
                    return true;
                }
                // we remove the item from the source, in case of MOVE
                //((DefaultListModel<String>)lsSource.getModel()).remove(lsSource.getSelectedIndex());
                return true;

            } catch (UnsupportedFlavorException | IOException ex) {
                Logger.getLogger(EditMoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(EditMoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }
}
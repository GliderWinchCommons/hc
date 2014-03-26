/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unitselection;

/**
 *
 * @author Matt
 */
public class SailplaneUnitsPanel extends javax.swing.JPanel {

    /**
     * Creates new form SailplaneUnitsPanel
     */
    public SailplaneUnitsPanel() {
        initComponents();
    }
    
    public int[] getSelectedIndices(){
        int[] indices = new int[3];
        indices[0] = sailplaneTensionSelection.getSelectedIndex();
        indices[1] = sailplaneWeightSelection.getSelectedIndex();
        indices[2] = sailplaneVelocitySelection.getSelectedIndex();
        return indices;
    }
    
    public void setSelectedIndices(int tensionIdx, int weightIdx, int velocityIdx){
        sailplaneTensionSelection.setSelectedIndex(tensionIdx);
        sailplaneWeightSelection.setSelectedIndex(weightIdx);
        sailplaneVelocitySelection.setSelectedIndex(velocityIdx);
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
        sailplaneWeightSelection = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        sailplaneVelocitySelection = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        sailplaneTensionSelection = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Sailplane Entry Units");

        jLabel2.setText("Weight:");

        sailplaneWeightSelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pounds (lbs)", "Kilograms (Kg)" }));

        jLabel3.setText("Velocity:");

        sailplaneVelocitySelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Miles per hour (mph)", "Kilometers per hour (Km/h)", "Meters per second (m/s)", "Knots (kn)" }));

        jLabel4.setText("Tension:");

        sailplaneTensionSelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Newtons (N)", "Pound-Force (lbf)", "Kilogram-Force (Kgf)" }));

        jLabel5.setText("includes: Max Tension, Max Weak Link Strength");

        jLabel6.setText("includes: Empty Weight, MGW");

        jLabel7.setText("includes: Max Winching Speed");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(117, 117, 117))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sailplaneVelocitySelection, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sailplaneWeightSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(sailplaneTensionSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 109, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sailplaneTensionSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sailplaneWeightSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sailplaneVelocitySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(103, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox sailplaneTensionSelection;
    private javax.swing.JComboBox sailplaneVelocitySelection;
    private javax.swing.JComboBox sailplaneWeightSelection;
    // End of variables declaration//GEN-END:variables
}
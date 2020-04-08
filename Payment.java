/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.npm149.entity;

/**
 *
 * @author RidhoNurOktaviansyah
 */
public class Payment {
    private String id;
    private String tanggal;
    private String nomorPO;
    private String supplier;
    private double totaltagihan;
    

    public Payment() {
    }

    public Payment(String id, String tanggal, String nomorPO, String supplier, double totaltagihan){
        this.id = id;
        this.tanggal = tanggal;
        this.nomorPO = nomorPO;
        this.supplier = supplier;
        this.totaltagihan = totaltagihan ;
   
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getNomorPO() {
        return nomorPO;
    }

    public void setNomorPO(String nomorPO) {
        this.nomorPO = nomorPO;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getTotalTagihan() {
        return totaltagihan;
    }

    public void setTotalTagihan(double totaltagihan ) {
        this.totaltagihan = totaltagihan;
    }

    public boolean insert(Servis srv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

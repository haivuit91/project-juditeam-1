/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.entities;

import java.util.List;

/**
 *
 * @author Admin
 */
public class TieuChi {
    private int maTC;
    private String tenTC;
    private String noiDung;
    private DiaPhuong diaPhuong;

    public TieuChi() {
    }

    public TieuChi(int maTC, String tenTC, String noiDung, DiaPhuong diaPhuong) {
        this.maTC = maTC;
        this.tenTC = tenTC;
        this.noiDung = noiDung;
        this.diaPhuong = diaPhuong;
    }

    public int getMaTC() {
        return maTC;
    }

    public void setMaTC(int maTC) {
        this.maTC = maTC;
    }

    public String getTenTC() {
        return tenTC;
    }

    public void setTenTC(String tenTC) {
        this.tenTC = tenTC;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public DiaPhuong getDiaPhuong() {
        return diaPhuong;
    }

    public void setDiaPhuong(DiaPhuong diaPhuong) {
        this.diaPhuong = diaPhuong;
    }
    
}
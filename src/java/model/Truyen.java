
package model;


public class Truyen {
    private String tenTruyen;
    private String tacGia;

    public Truyen(String tenTruyen, String tacGia) {
        this.tenTruyen = tenTruyen;
        this.tacGia = tacGia;
    }

    public Truyen() {
    }
    
    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }    
}

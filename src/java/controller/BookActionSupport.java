package controller;

import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import model.bookCommand;

public class BookActionSupport extends ActionSupport {

    private List<Truyen> listBook = new ArrayList<Truyen>();
    private Truyen truyen = new Truyen();
    private String ten = "";

    public BookActionSupport() {
    }

    public List<Truyen> getListBook() {
        return listBook;
    }

    public void setListBook(List<Truyen> listBook) {
        this.listBook = listBook;
    }

    public Truyen getTruyen() {
        return truyen;
    }

    public void setTruyen(Truyen truyen) {
        this.truyen = truyen;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String add() {
        try {
            bookCommand.addBook(this.truyen);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookActionSupport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "success";
    }

    public String del() {
        try {
            bookCommand.delBook(this.ten);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookActionSupport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "success";
    }

    public String find() {
        try {           
            this.truyen=bookCommand.findBook(this.ten);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookActionSupport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "success";
    }
    
    public String update() {
        try {           
            bookCommand.updateBook(this.truyen);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookActionSupport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "success";
    }

    public String getList() {
        try {
            this.listBook = bookCommand.getListBook();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookActionSupport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "success";
    }
}

package com.example.recycleview;



public class Records {

    private  int id;
    private String date;
    private int surat;
    private int start;
    private int end;
    private int sabki;
    private int manzil;


    public Records( int id , String date, int surat , int start , int end , int sabki , int manzil ) {
        this.id = id;
        this.date = date;
        this.surat = surat;
        this.start = start;
        this.end = end;
        this.sabki = sabki;
        this.manzil = manzil;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setDate(String date){
        this.date = date;
    }



    public int getId(){
        return this.id;
    }

    public String getDate(){
        return this.date;
    }

    public int getSurat(){
        return this.surat;
    }

    public int getStart(){
        return this.start;
    }

    public int getEnd(){
        return this.end;
    }


    public int getSabki(){
        return this.sabki;
    }

    public int getManzil(){
        return this.manzil;
    }



    @Override
    public String toString() {
        return "Records [id=" + id + ", date=" + date + ", surat=" + surat + ", start=" + start + ", sabki=" + sabki + " , manzil=" + manzil + "]";
    }

}

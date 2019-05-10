/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Adamoc
 */
public class Seat implements Serializable {
    public int row;
        public int column;

        public Seat(int row, int column) { //konstruktor inttel megadott formához
            this.row = row;
            this.column = column;
        }
        
        public Seat(String s) { //konstruktor a button id-k szerinti formához
            String[] tmp = s.split("-");
            this.row = Integer.parseInt(tmp[0]);
            this.column = Integer.parseInt(tmp[1]);
        }
        
        
        @Override
        public String toString() {
            return (row+1) + "-" + (column+1); //+1 a nullától való indexelés miatt
        } 

    
    /*public boolean equals(Object obj) {
        final Seat other = (Seat) obj;
        if (this.row != this.row || this.column != other.column)
            return false;
        return true;
    }*/

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.row;
        hash = 61 * hash + this.column;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Seat other = (Seat) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }
    
    
}

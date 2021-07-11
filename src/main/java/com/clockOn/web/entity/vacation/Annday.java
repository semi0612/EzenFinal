package com.clockOn.web.entity.vacation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Annday {
   
   private int total_annday;
   private float annday_used;
   private int annday_rest;
   
   public Annday(int total_annday,float annday_used, int annday_rest) {
      this.total_annday = total_annday;
      this.annday_used = annday_used;
      this.annday_rest = annday_rest;
   }
}
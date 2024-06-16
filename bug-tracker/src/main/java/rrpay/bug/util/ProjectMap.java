package rrpay.bug.util;

import java.util.HashMap;
import java.util.Map;

/**
 All project names are:
 DIRECTDEBITPAY, INVOICEPAY, INSTALMENTPAY, DIRECTDEBITPAY

 The respective project descriptions are:
 "Pay by Direct Debit", "Pay by Invoice", "Pay in Instalments", "Pay by Direct Debit"
  */
public class ProjectMap {
  public static final Map<String,String> projects = new HashMap<>();


static {
  projects.put("INVOICEPAY","Pay by Invoice");
  
  projects.put("INSTALMENTPAY","Pay in Instalments");
  
  projects.put("DIRECTDEBITPAY","Pay by Direct Debit");
}  
}

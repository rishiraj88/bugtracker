package rrpay.bug.entities.constants;

import java.util.HashMap;
import java.util.Map;

public class ProjectMap {
  public static final Map<String,String> projects = new HashMap<>();
static {
  projects.put("INVOICEPAY","Pay by Invoice");
  
  projects.put("INSTALMENTPAY","Pay in Instalments");
  
  projects.put("DIRECTDEBITPAY","Pay by Direct Debit");
}  
}

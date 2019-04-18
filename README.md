# primefaces
This is an primefaces project to show bugs in Primefaces 7.0<BR>
How to reproduct the bug.<BR>
1)Start the application<BR>
2)Input some digtial data in Length(mm), Width(mm), Height(mm) or Vol(m3) input fields<BR>
  when the value is changed, it will invoke the managed bean to update the total vol or total weight 
  by java code.
  			PrimeFaces.current().ajax().update("entity_form:bagsTable:total_vol");
3) The total_vol output field is not changed.
  If primefaces is switched into 6.2 verison, the  total_vol field will change

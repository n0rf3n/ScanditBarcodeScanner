package com.konylabs.ffi;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import com.konylabs.api.TableLib;
import com.konylabs.vm.LuaTable;



import com.kony.scandit.barcodeffi.ScanditBarcodeScanner;
import com.konylabs.libintf.Library;
import com.konylabs.libintf.JSLibrary;
import com.konylabs.vm.LuaError;
import com.konylabs.vm.LuaNil;


public class N_ScanditNS extends JSLibrary {

 
 
	public static final String invokeAAR = "invokeAAR";
 
	String[] methods = { invokeAAR };


 Library libs[] = null;
 public Library[] getClasses() {
 libs = new Library[0];
 return libs;
 }



	public N_ScanditNS(){
	}

	public Object[] execute(int index, Object[] params) {
		// TODO Auto-generated method stub
		Object[] ret = null;
 try {
		int paramLen = params.length;
 int inc = 1;
		switch (index) {
 		case 0:
 if (paramLen != 2){ return new Object[] {new Double(100),"Invalid Params"}; }
 java.lang.String Apikey0 = null;
 if(params[0] != null && params[0] != LuaNil.nil) {
 Apikey0 = (java.lang.String)params[0];
 }
 com.konylabs.vm.Function callbackfunction0 = null;
 if(params[1] != null && params[1] != LuaNil.nil) {
 callbackfunction0 = (com.konylabs.vm.Function)params[1];
 }
 ret = this.invokeAAR( Apikey0, callbackfunction0 );
 
 			break;
 		default:
			break;
		}
 }catch (Exception e){
			ret = new Object[]{e.getMessage(), new Double(101), e.getMessage()};
		}
		return ret;
	}

	public String[] getMethods() {
		// TODO Auto-generated method stub
		return methods;
	}
	public String getNameSpace() {
		// TODO Auto-generated method stub
		return "ScanditNS";
	}


	/*
	 * return should be status(0 and !0),address
	 */
 
 
 	public final Object[] invokeAAR( java.lang.String inputKey0, com.konylabs.vm.Function inputKey1 ){
 
		Object[] ret = null;
 com.kony.scandit.barcodeffi.ScanditBarcodeScanner.startBarCodeScanning( inputKey0
 , (com.konylabs.vm.Function)inputKey1
 );
 
 ret = new Object[]{LuaNil.nil, new Double(0)};
 		return ret;
	}
 
};

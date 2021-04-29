package org.automation.testrunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.automation.helpers.Helpers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class ApiTestRunner {

    public final String API_PATH="http://localhost:3030";
    Map<String, Object> data = new HashMap<>();
	int productId=0;
   
    @Test
    public void testGetAllProducts() {
      RestAssured.given()
                .header("Content-type", "application/json")
                .get(API_PATH+"/products")
                .then()
                .assertThat()
                .statusCode(200);
   
    }
    
    
    
    
    
    public void getProduct(int id,int statusCode) {
    	
    	 RestAssured.when()
         .get(API_PATH+"/products/"+id+"/")
         .then()
         .assertThat()
         .statusCode(statusCode);
    }
    @Test
    public void checkNotFoundProduct() {
        //check if 404 will be retuend for non existing id
    	getProduct(9999911,404);
    }
    
    public void fillProduct(Map<String,Object> request,int statusCode) {
    	
    productId=RestAssured.given()
    		 //.log().all()
     .contentType(ContentType.JSON)
             .and()
             .body(request)
             .when()
             .post(API_PATH+"/products")
             .then()
             .assertThat()
             .statusCode(statusCode)
             .extract()
             .path("id")
             ;  
     
    
    }
   
    public void verifyOnProduct(int statusCode) {
    	
    	RestAssured.given()
    	.contentType(ContentType.JSON)
        .and()
        .when()
        .get(API_PATH+"/products/"+productId)
        .then()
        .assertThat()
        .statusCode(statusCode)
  	  	.body("name", equalTo(data.get("name")))
    	.body("type", equalTo(data.get("type")))
    	.body("upc", equalTo(data.get("upc")))
    	.body("description", equalTo(data.get("description")))
    	.body("model", equalTo(data.get("model")))
    	.body("price", equalTo(data.get("price")));
    
    	
    }
   
    @DataProvider (name = "ProductData")
    public Object[][] getProductData(){
    	
    	Object[][] data=null;
		try {
			data = Helpers.readExcel("data.xls", "api");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
    	
    }
    @Test(dataProvider = "ProductData") 
    public void testCreateProduct(String[] testcase) {
        //check if 404 will be returned for non existing id
    
    	 
    	data.put("name",testcase[0]);
    	data.put("type",testcase[1]);
    	data.put("upc", testcase[2]);
    	data.put("description", testcase[3]);
    	data.put("price", Integer.parseInt(testcase[4]));
    	data.put("model", testcase[5]);
         
        
         fillProduct(data,201);
         verifyOnProduct(200);
    }
    
    @Test(dataProvider = "ProductData") 
    public void testCreateProductWithInvalidData(String[] testcase) {
        //check if 404 will be returned for non existing id
    	 Map<String, Object> emptyData = new HashMap<>();
    	 
    	 emptyData.put("name","");
    	 emptyData.put("type","");
    	 emptyData.put("upc", "");
    	 emptyData.put("description", "");
    	 emptyData.put("price", 0);
    	 emptyData.put("model", "");
         
        
    	 RestAssured.given()
    	 .contentType(ContentType.JSON)
         .and()
         .body(emptyData)
         .when()
         .post(API_PATH+"/products")
         .then()
         .assertThat()
         .statusCode(400);
         
        
    }
    
    @Test(dataProvider = "ProductData",dependsOnMethods = { "testCreateProduct"}) 
    public void testUpdateProduct(String[] testcase) {
        //check if 404 will be returned for non existing id
    
         
         data.put("price", Integer.parseInt(testcase[6]));
         data.put("model", testcase[7]);
         
         	
         RestAssured.given()
                 .header("Content-type", "application/json")
                 .and()
                 .body(data)
                 .when()
                 .patch(API_PATH+"/products/"+productId)
                 .then()
                 .assertThat()
                 .statusCode(200);
         
    
         verifyOnProduct(200);
    }

    
    @Test(dependsOnMethods = { "testCreateProduct","testUpdateProduct" }) 
    public void testDeleteProduct() {
    
         RestAssured.given()
                 .header("Content-type", "application/json")
                 .and()
                 .when()
                 .delete(API_PATH+"/products/"+productId)
                 .then()
                 .assertThat()
                 .statusCode(200);
         
    
         getProduct(productId,404);
    }
    
    @Test(dependsOnMethods = { "testDeleteProduct"}) 
    public void testDeleteNonExistingProduct() {
        
        RestAssured.given()	
                .header("Content-type", "application/json")
                .and()
                .when()
                .delete(API_PATH+"/products/"+productId)
                .then()
                .assertThat()
                .statusCode(404);
        
  
   }
}
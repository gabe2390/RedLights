    package zipcoder.controllers;

    import com.fasterxml.jackson.databind.ObjectMapper;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.ResponseBody;
    import org.springframework.web.bind.annotation.RestController;
    import zipcoder.models.RedLight;
    import zipcoder.models.RedLightDAO;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.net.MalformedURLException;
    import java.net.URL;
    import java.net.URLConnection;
    import java.util.HashSet;
    import java.util.Scanner;
    import java.util.Set;
    import java.util.regex.Pattern;

    /**
     * Created by ghumphrey on 10/26/15.
     */
    @RestController
    public class RedLightCreationController {

        final static String uri = "https://data.phila.gov/resource/8qmh-bvue.json";

        @Autowired
        RedLightDAO redLightDAO;
        /**
         * If the requested item is not in the database already, call methods to connect to API
         * and cache objects in database. Then retrieves the object and returns it if it exists. Otherwise returns
         * an empty RedLight object
         * @param ID - Integer retrieved from get request
         * @return - RedLight - a single red light object
         */
        @RequestMapping(value="/camera", method= RequestMethod.GET)
        @ResponseBody
        public RedLight getRedLight(Integer ID){
            RedLight light= null;
            try {
                //if ID does not exist inside the database, contact the API - connect() in this case
                // - SEE LINE 69
                if(redLightDAO.findOne(ID)==null){
                    for(RedLight camera : getObjects() ){
                        redLightDAO.save(camera);
                    }

                    light= redLightDAO.findOne(ID);
                }
                else{
                    light= redLightDAO.findOne(ID);
                }

                System.out.println(light);
            }
            catch (Exception e){
                e.printStackTrace();
                    return new RedLight();
            }
            return light;
        }

        /**
         * uses URL and URLConnection to retrieve a string of Json data from API, then sends that
         * String to getObjects() method, and returns the result of that method
         * @return
         */
     /*   public RedLight[] connect() {
            URL url = null;
            URLConnection connection = null;
            BufferedReader reader = null;
            String json = "";

            try {
                //establish connection with API
                url = new URL(uri);
                connection = url.openConnection();
                connection.connect();
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String data;

                //read data in and build JSON str ing
                while ((data = reader.readLine()) != null) {
                    json += data;
                }
                System.out.println(json);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //send  String of JSON data to getObjects() to be parsed, and
            //return the value returned from that method -SEE LINE 105
            return getObjects(json);
        }
    */
        /**
         * Uses Jackson library ObjectMapper to create an array of RedLight objects
         * from the json string sent from the connect method
         * @return RedLight[]
         */
        public RedLight[] getObjects(){
            ObjectMapper mapper = new ObjectMapper(); //Jackson library object
            RedLight[] redLights= null;
            Set<String> sd= new HashSet<String>();


            try {
                //parse data in to POJOs
                redLights= mapper.readValue(new URL(uri), RedLight[].class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return redLights;
        }
    }

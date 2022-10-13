package com.sukiasian.quotesjavabot.properties;

import lombok.Getter;
import lombok.Setter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Setter
@Getter
public class PropertyRetriever {
    private FileInputStream fis;
    private Properties property;

        public PropertyRetriever(String propertiesFileName) throws FileNotFoundException, IOException {
            try {
                this.fis = new FileInputStream("src/main/resources/" + propertiesFileName);
            } catch(FileNotFoundException e) {
                this.fis = new FileInputStream("src/main/resources/" + propertiesFileName + ".origin");
            }

            this.property = new Properties();

            property.load(fis);
        }

}

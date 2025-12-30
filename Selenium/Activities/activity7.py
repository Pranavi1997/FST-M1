from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get(" https://training-support.net/webelements/dynamic-controls")
    print("Title of the page: ",driver.title)
    inputtext = driver.find_element(By.ID,"textInput")
    print("Input text is enabled: " ,inputtext.is_enabled())
    driver.find_element(By.ID,"textInputButton").click()
    print("Input text is enabled: " ,inputtext.is_enabled())
    inputtext.send_keys("Example")
    print("Input text Message: " ,inputtext.get_property("value"))
    driver.close()
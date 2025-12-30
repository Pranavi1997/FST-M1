from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.color import Color
with webdriver.Firefox() as driver:
    driver.get(" https://training-support.net/webelements/target-practice")
    print("Title of the page: ",driver.title)
    thirdheadermessage = driver.find_element(By.XPATH,"//h3[contains(text(),'#3')]")
    print("Third header message : " ,thirdheadermessage.text )
    fifth_heading_color = Color.from_string(driver.find_element(By.XPATH, "//h5[contains(text(),'#5')]").value_of_css_property("color"))
    print("Fifth heading colour as Hexcode: ", fifth_heading_color.hex)
    print("Fifth heading colour as RGB: ", fifth_heading_color.rgb)
    purplebutton = driver.find_element(By.XPATH,"//button[text() = 'Purple']")
    print("Purple button class: " ,purplebutton.get_attribute("class"))
    slatebutton = driver.find_element(By.XPATH,"//button[contains(text(),'Slate')]")
    print("Slate button message : ",slatebutton.text)
    driver.close()
from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get(" https://training-support.net/webelements/dynamic-controls")
    print("Title of the page: ",driver.title)
    checkbox = driver.find_element(By.ID,"checkbox")
    togglecheckbox = driver.find_element(By.XPATH,"//button[text() = 'Toggle Checkbox']").click()
    print("Check is visible: " , checkbox.is_displayed())
    togglecheckbox = driver.find_element(By.XPATH,"//button[text() = 'Toggle Checkbox']").click()
    print("Check is visible: " , checkbox.is_displayed())
    driver.close()
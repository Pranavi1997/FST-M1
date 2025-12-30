from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get(" https://training-support.net/webelements/login-form/")
    print("Title of the page: ",driver.title)
    driver.find_element(By.XPATH,"//input[@name = 'username']").send_keys("admin")
    driver.find_element(By.XPATH, "//input[@id = 'password']").send_keys("password")
    login = driver.find_element(By.XPATH,"//button[text() = 'Submit']")
    login.click()
    message = driver.find_element(By.XPATH,"//h1[contains(text(), 'Success')]")
    print("Login Message: ", message.text)
    driver.close()
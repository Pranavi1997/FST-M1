from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get(" https://training-support.net/webelements/login-form/")
    print("Title of the page: ",driver.title)
    driver.find_element(By.NAME,"username").send_keys("admin")
    driver.find_element(By.ID, "password").send_keys("password")
    login = driver.find_element(By.CSS_SELECTOR,".svelte-1pdjkmx")
    login.click()
    message = driver.find_element(By.TAG_NAME,"h1")
    print("Login Message: ", message.text)
    driver.close()
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains
with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/keyboard-events")
    print("Title of the page: ",driver.title)
    actions = ActionChains(driver)
    actions.send_keys("This is coming from selenium").perform()
    message = driver.find_element(By.CSS_SELECTOR,"h1.mt-3").text
    print(message)
    driver.close()
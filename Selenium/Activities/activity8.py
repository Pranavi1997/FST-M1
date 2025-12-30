from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains
with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/mouse-events")
    print("Title of the page: ",driver.title)
    actions = ActionChains(driver)
    cargolock = driver.find_element(By.XPATH,"//h1[text()='Cargo.lock']")
    cargotoml = driver.find_element(By.XPATH,"//h1[text()='Cargo.toml']")
    src = driver.find_element(By.XPATH,"//h1[text()='src']")
    target = driver.find_element(By.XPATH,"//h1[text()='target']")
    actions.click(cargolock).pause(1).move_to_element(cargotoml).pause(5).click(cargotoml).perform()
    message1 = driver.find_element(By.ID,"result").text
    print(message1)
    actions.double_click(src).pause(3).pause(5).context_click(target).pause(3).perform()
    actions.click(driver.find_element(By.XPATH,"//div[@id='menu']/div/ul/li[1]")).pause(5).perform()
    message2 = driver.find_element(By.ID,"result").text
    print(message2)
    driver.close()


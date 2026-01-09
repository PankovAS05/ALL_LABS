import math
import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.common.exceptions import NoAlertPresentException

# ========================
# Page Object: BasePage
# ========================
class BasePage:
    def __init__(self, browser, url):
        self.browser = browser
        self.url = url

    def open(self):
        self.browser.get(self.url)

    def solve_quiz_and_get_code(self):
        alert = self.browser.switch_to.alert
        x = alert.text.split(" ")[2]
        answer = str(math.log(abs(12 * math.sin(float(x)))))
        alert.send_keys(answer)
        alert.accept()
        try:
            alert = self.browser.switch_to.alert
            alert_text = alert.text
            print(f"Your code: {alert_text}")
            alert.accept()
        except NoAlertPresentException:
            print("No second alert presented")

# ========================
# Page Object: ProductPage
# ========================
class ProductPage(BasePage):
    ADD_TO_BASKET_BUTTON = (By.CSS_SELECTOR, ".btn-add-to-basket")
    PRODUCT_NAME = (By.CSS_SELECTOR, ".product_main h1")
    PRODUCT_PRICE = (By.CSS_SELECTOR, ".product_main .price_color")
    MESSAGE_PRODUCT_ADDED = (By.CSS_SELECTOR, "#messages div.alert-success strong")
    MESSAGE_BASKET_TOTAL = (By.CSS_SELECTOR, "#messages div.alert-info strong")

    def add_product_to_basket(self):
        button = self.browser.find_element(*self.ADD_TO_BASKET_BUTTON)
        button.click()

    def should_be_correct_product_added_message(self):
        product_name = self.browser.find_element(*self.PRODUCT_NAME).text
        message_product = self.browser.find_element(*self.MESSAGE_PRODUCT_ADDED).text
        assert product_name == message_product, \
            f"Expected product name '{product_name}', but got '{message_product}' in success message."

    def should_be_correct_basket_price(self):
        product_price = self.browser.find_element(*self.PRODUCT_PRICE).text
        basket_total = self.browser.find_element(*self.MESSAGE_BASKET_TOTAL).text
        assert product_price == basket_total, \
            f"Expected basket total '{product_price}', but got '{basket_total}'."

# ========================
# PyTest fixture
# ========================
@pytest.fixture(scope="function")
def browser():
    print("\nstart browser for test..")
    browser = webdriver.Chrome()
    browser.maximize_window()
    yield browser
    print("\nquit browser..")
    browser.quit()

# ========================
# Actual test
# ========================
@pytest.mark.smoke
def test_guest_can_add_product_to_basket(browser):
    link = "http://selenium1py.pythonanywhere.com/catalogue/the-shellcoders-handbook_209/?promo=newYear"
    page = ProductPage(browser, link)
    page.open()
    page.add_product_to_basket()
    page.solve_quiz_and_get_code()
    page.should_be_correct_product_added_message()
    page.should_be_correct_basket_price()

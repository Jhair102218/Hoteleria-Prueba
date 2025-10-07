document.addEventListener("DOMContentLoaded", () => {
  // Navegación suave entre secciones
  document.querySelectorAll('nav a[href^="#"]').forEach((anchor) => {
    anchor.addEventListener("click", function (e) {
      e.preventDefault();
      const destino = document.querySelector(this.getAttribute("href"));
      if (destino) {
        destino.scrollIntoView({ behavior: "smooth" });
      }
    });
  });

  // Inicializar animaciones AOS
  AOS.init({
    duration: 1000,
    once: true,
    offset: 120,
  });

  // Función auxiliar para actualizar texto si el elemento existe
  function actualizarTexto(id, texto) {
    const el = document.getElementById(id);
    if (el) el.textContent = texto;
  }

  // Obtener clima actual en Lima desde Meteosource
  fetch("https://api.meteosource.com/v1/free/point?place=lima&sections=current&key=ntilhgdgm23mwu6hvtmiszf3omi2vclqd4ojd77l")
    .then((res) => res.json())
    .then((data) => {
      const temp = data.current.temperature;
      const desc = data.current.weather;
      actualizarTexto("weather-info", `Actualmente: ${temp}°C, ${desc}`);
    })
    .catch((error) => {
      console.error("Error al obtener clima:", error);
      actualizarTexto("weather-info", "No se pudo cargar el clima.");
    });

  // Obtener tipo de cambio USD → PEN desde SUNAT
  fetch("https://api.apis.net.pe/v1/tipo-cambio-sunat")
    .then((res) => res.json())
    .then((data) => {
      actualizarTexto("exchange-info", `1 USD = S/. ${data.venta} (SUNAT)`);
    })
    .catch((error) => {
      console.error("Error al obtener tipo de cambio:", error);
      actualizarTexto("exchange-info", "No se pudo cargar el tipo de cambio.");
    });
});
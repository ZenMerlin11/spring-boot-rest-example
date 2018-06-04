(function (window) {
  'use strict';
  var App = window.App || {};

  function Truck(truckId, db) {
    console.log('New Truck constructed');
    this.truckId = truckId;
    this.db = db;
  }

  Truck.prototype.createOrder = function(order) {
    console.log('Adding order for ' + order.emailAddress);
    return this.db.add(order.emailAddress, order);
  };

  Truck.prototype.deliverOrder = function(customerId) {
    console.log('Delivering order for '.concat(customerId));
    return this.db.remove(customerId);
  };

  Truck.prototype.printOrders = function(printFn) {
    return this.db.getAll()
      .then(function(orders) {
        var customerIdArray = Object.keys(orders);

        console.log('Truck #'.concat(this.truckId).concat(' has pending orders: '));
        customerIdArray.forEach(function(id) {
          console.log(orders[id]);
          if (printFn) {
            printFn(orders[id]);
          }
        }.bind(this));
      }.bind(this));
  };

  App.Truck = Truck;
  window.App = App;
})(window);